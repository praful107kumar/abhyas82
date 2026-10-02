package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Question entity stored locally in Room database for offline test execution.
 */
@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey
    val questionId: String,
    val chapterId: Int,
    val chapter: String,
    val topic: String,
    val testType: String, // PRACTICE, TEST_1, TEST_2, TEST_3, REVISION, FULL_MOCK
    val questionType: String, // MCQ, ASSERTION_REASON, COMPETENCY_BASED, CASE_BASED
    val questionText: String,
    val optionsJson: String, // JSON array string e.g. ["Opt A", "Opt B", "Opt C", "Opt D"]
    val correctAnswer: Int, // 0-based index (0=A, 1=B, 2=C, 3=D)
    val explanation: String,
    val marks: Int = 1,
    val difficulty: String = "Medium", // Easy, Medium, Hard
    val competency: String = "Conceptual Understanding"
)

/**
 * Student local session entity.
 * isActivated is FALSE until transaction ID is submitted and verified!
 */
@Entity(tableName = "student_session")
data class StudentSessionEntity(
    @PrimaryKey
    val studentId: String,
    val studentName: String,
    val studentEmail: String,
    val token: String,
    val isVerified: Boolean = true,
    val isActivated: Boolean = false, // Must be verified with Transaction ID before app entry!
    val coins: Int = 100, // Starting welcome reward coins
    val activationDate: Long = 0L,
    val referenceId: String = "", // Holds the student's entered Transaction ID / UTR
    val payeeName: String = "Mrs CHANDA DEVI",
    val paymentAmount: String = "₹10.00",
    val isLoggedIn: Boolean = true
)

/**
 * Offline test attempt entity saving student performance history.
 */
@Entity(tableName = "test_attempts")
data class TestAttemptEntity(
    @PrimaryKey
    val attemptId: String,
    val studentId: String,
    val chapterId: Int,
    val testType: String,
    val testTitle: String,
    val score: Int,
    val totalMarks: Int,
    val percentage: Float,
    val correctCount: Int,
    val incorrectCount: Int,
    val unattemptedCount: Int,
    val accuracy: Float,
    val timeUsedSeconds: Long,
    val coinsEarned: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val responsesJson: String // Map of questionId -> selectedOptionIndex
)

data class Chapter(
    val id: Int,
    val number: Int,
    val title: String,
    val subject: String, // Chemistry, Biology, Physics, Natural Resources
    val description: String,
    val totalTests: Int = 5,
    val keyTopics: List<String>
)

enum class TestType(val id: String, val title: String, val description: String, val durationMinutes: Int, val questionCount: Int = 20) {
    PRACTICE("PRACTICE", "Practice Test (20 Qs)", "20 essential questions with conceptual focus & relaxed timer", 20, 20),
    TEST_1("TEST_1", "Test 1: NCERT Core (20 Qs)", "20 core NCERT concepts & textbook application questions", 25, 20),
    TEST_2("TEST_2", "Test 2: Competency & HOTS (20 Qs)", "20 high order thinking, diagrammatic & competency questions", 25, 20),
    TEST_3("TEST_3", "Test 3: Board Pattern (20 Qs)", "20 standard CBSE board examination & assertion-reason questions", 25, 20),
    REVISION("REVISION", "Revision Test: Rapid Fire (20 Qs)", "20 rapid-fire chapter revision & formula questions", 20, 20),
    FULL_MOCK("FULL_MOCK", "Grand Mock Test (20 Qs)", "20 full syllabus CBSE Class 10 Science simulated questions", 30, 20)
}
