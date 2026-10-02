package com.example.data.repository

import com.example.data.local.StudentSessionDao
import com.example.data.model.StudentSessionEntity
import com.example.data.remote.SupabaseClient
import com.example.data.remote.SupabaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID

sealed class AuthResult {
    data class Success(val session: StudentSessionEntity) : AuthResult()
    data class Error(val message: String) : AuthResult()
}

class AuthRepository(private val sessionDao: StudentSessionDao) {

    val currentSession: Flow<StudentSessionEntity?> = sessionDao.getCurrentSession()

    suspend fun getCurrentSessionSync(): StudentSessionEntity? = withContext(Dispatchers.IO) {
        sessionDao.getCurrentSessionSync()
    }

    suspend fun login(email: String, password: String): AuthResult = withContext(Dispatchers.IO) {
        if (email.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return@withContext AuthResult.Error("Please enter a valid student email address")
        }
        if (password.length < 4) {
            return@withContext AuthResult.Error("Password must be at least 4 characters")
        }

        val studentId = UUID.nameUUIDFromBytes(email.trim().lowercase().toByteArray()).toString()
        val studentName = email.substringBefore("@").replace(".", " ").capitalizeWords()

        // Check if there was already an activated session for this student in local database
        val existingSession = sessionDao.getCurrentSessionSync()
        val isAlreadyActivated = existingSession != null && existingSession.studentEmail.equals(email.trim(), ignoreCase = true) && existingSession.isActivated

        val session = StudentSessionEntity(
            studentId = studentId,
            studentName = if (existingSession != null && existingSession.studentName.isNotBlank()) existingSession.studentName else studentName,
            studentEmail = email.trim(),
            token = "abhyas_auth_token_${System.currentTimeMillis()}",
            isVerified = true,
            isActivated = true,
            coins = existingSession?.coins ?: 150,
            activationDate = if (existingSession?.activationDate != null && existingSession.activationDate > 0L) existingSession.activationDate else System.currentTimeMillis(),
            referenceId = existingSession?.referenceId ?: "FREE_ACCESS",
            payeeName = "Mrs CHANDA DEVI",
            paymentAmount = "₹10.00",
            isLoggedIn = true
        )
        sessionDao.saveSession(session)
        AuthResult.Success(session)
    }

    suspend fun register(name: String, email: String, password: String): AuthResult = withContext(Dispatchers.IO) {
        if (name.isBlank() || name.length < 2) {
            return@withContext AuthResult.Error("Please enter student's full name")
        }
        if (email.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return@withContext AuthResult.Error("Please enter a valid student email address")
        }
        if (password.length < 4) {
            return@withContext AuthResult.Error("Password must be at least 4 characters")
        }

        val studentId = UUID.nameUUIDFromBytes(email.trim().lowercase().toByteArray()).toString()

        val session = StudentSessionEntity(
            studentId = studentId,
            studentName = name.trim().capitalizeWords(),
            studentEmail = email.trim(),
            token = "abhyas_reg_token_${System.currentTimeMillis()}",
            isVerified = true,
            isActivated = true,
            coins = 200, // Registration welcome reward coins
            activationDate = System.currentTimeMillis(),
            referenceId = "REG_AUTO_ACTIVE",
            payeeName = "Mrs CHANDA DEVI",
            paymentAmount = "₹10.00",
            isLoggedIn = true
        )
        sessionDao.saveSession(session)
        AuthResult.Success(session)
    }

    suspend fun ensureDefaultSession(defaultName: String, defaultEmail: String): StudentSessionEntity = withContext(Dispatchers.IO) {
        val existing = sessionDao.getCurrentSessionSync()
        if (existing != null) {
            if (!existing.isActivated || !existing.isLoggedIn) {
                val updated = existing.copy(isActivated = true, isLoggedIn = true)
                sessionDao.saveSession(updated)
                return@withContext updated
            }
            return@withContext existing
        }

        val studentId = UUID.nameUUIDFromBytes(defaultEmail.trim().lowercase().toByteArray()).toString()
        val defaultSession = StudentSessionEntity(
            studentId = studentId,
            studentName = defaultName,
            studentEmail = defaultEmail,
            token = "abhyas_init_${System.currentTimeMillis()}",
            isVerified = true,
            isActivated = true,
            coins = 250,
            activationDate = System.currentTimeMillis(),
            referenceId = "PRAFUL_DIRECT_ACCESS",
            payeeName = "Mrs CHANDA DEVI",
            paymentAmount = "₹10.00",
            isLoggedIn = true
        )
        sessionDao.saveSession(defaultSession)
        defaultSession
    }

    /**
     * Verifies the Transaction ID with Supabase backend and unlocks the student application.
     */
    suspend fun verifyAndActivate(
        session: StudentSessionEntity,
        transactionId: String
    ): SupabaseResult = withContext(Dispatchers.IO) {
        val result = SupabaseClient.verifyAndRecordTransaction(
            studentId = session.studentId,
            studentName = session.studentName,
            studentEmail = session.studentEmail,
            transactionId = transactionId,
            amount = "10.00",
            payee = "Mrs CHANDA DEVI"
        )

        if (result is SupabaseResult.Success) {
            // Activate session in local Room database
            sessionDao.activateStudentSession(
                studentId = session.studentId,
                transactionId = result.transactionId,
                timestamp = result.verifiedAt
            )
        }

        result
    }

    suspend fun logout() = withContext(Dispatchers.IO) {
        sessionDao.logout()
    }

    suspend fun addCoins(studentId: String, amount: Int) = withContext(Dispatchers.IO) {
        sessionDao.addCoins(studentId, amount)
    }

    private fun String.capitalizeWords(): String {
        return split(" ").joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }
    }
}
