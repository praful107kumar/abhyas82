package com.example.data.repository

import android.content.Context
import com.example.data.local.AttemptDao
import com.example.data.local.QuestionDao
import com.example.data.local.SeedQuestions
import com.example.data.local.StudentSessionDao
import com.example.data.model.QuestionEntity
import com.example.data.model.TestAttemptEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TestRepository(
    private val questionDao: QuestionDao,
    private val attemptDao: AttemptDao,
    private val sessionDao: StudentSessionDao
) {
    val allAttempts: Flow<List<TestAttemptEntity>> = attemptDao.getAllAttempts()

    suspend fun ensureQuestionsSeeded(context: Context) = withContext(Dispatchers.IO) {
        val count = questionDao.getQuestionCount()
        if (count < 1300) {
            val list = SeedQuestions.loadAllQuestions(context)
            if (list.isNotEmpty()) {
                questionDao.insertQuestions(list)
            }
        }
    }

    fun getQuestionsForTest(chapterId: Int, testType: String): Flow<List<QuestionEntity>> {
        return questionDao.getQuestionsForChapterTest(chapterId, testType)
    }

    fun getQuestionsForChapter(chapterId: Int): Flow<List<QuestionEntity>> {
        return questionDao.getQuestionsForChapter(chapterId)
    }

    fun getFullMockQuestions(): Flow<List<QuestionEntity>> {
        return questionDao.getFullMockQuestions()
    }

    fun getAttemptsForChapter(chapterId: Int): Flow<List<TestAttemptEntity>> {
        return attemptDao.getAttemptsForChapter(chapterId)
    }

    fun getAttemptById(attemptId: String): Flow<TestAttemptEntity?> {
        return attemptDao.getAttemptById(attemptId)
    }

    fun getBestAttempt(chapterId: Int, testType: String): Flow<TestAttemptEntity?> {
        return attemptDao.getBestAttemptForTest(chapterId, testType)
    }

    suspend fun submitAttempt(attempt: TestAttemptEntity) = withContext(Dispatchers.IO) {
        attemptDao.insertAttempt(attempt)
        // Award coins to the student for their performance!
        if (attempt.coinsEarned > 0) {
            sessionDao.addCoins(attempt.studentId, attempt.coinsEarned)
        }
    }
}
