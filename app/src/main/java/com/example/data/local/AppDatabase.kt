package com.example.data.local

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.model.QuestionEntity
import com.example.data.model.StudentSessionEntity
import com.example.data.model.TestAttemptEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Dao
interface QuestionDao {
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE chapterId = :chapterId AND testType = :testType")
    fun getQuestionsForChapterTest(chapterId: Int, testType: String): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE chapterId = :chapterId")
    fun getQuestionsForChapter(chapterId: Int): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE testType = 'FULL_MOCK'")
    fun getFullMockQuestions(): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE questionId = :questionId LIMIT 1")
    suspend fun getQuestionById(questionId: String): QuestionEntity?

    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionEntity>)
}

@Dao
interface StudentSessionDao {
    @Query("SELECT * FROM student_session WHERE isLoggedIn = 1 LIMIT 1")
    fun getCurrentSession(): Flow<StudentSessionEntity?>

    @Query("SELECT * FROM student_session WHERE isLoggedIn = 1 LIMIT 1")
    suspend fun getCurrentSessionSync(): StudentSessionEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSession(session: StudentSessionEntity)

    @Query("UPDATE student_session SET coins = coins + :coinsToAdd WHERE studentId = :studentId")
    suspend fun addCoins(studentId: String, coinsToAdd: Int)

    @Query("UPDATE student_session SET isActivated = 1, referenceId = :transactionId, activationDate = :timestamp WHERE studentId = :studentId")
    suspend fun activateStudentSession(studentId: String, transactionId: String, timestamp: Long)

    @Query("UPDATE student_session SET isLoggedIn = 0")
    suspend fun logout()
}

@Dao
interface AttemptDao {
    @Query("SELECT * FROM test_attempts ORDER BY timestamp DESC")
    fun getAllAttempts(): Flow<List<TestAttemptEntity>>

    @Query("SELECT * FROM test_attempts WHERE chapterId = :chapterId ORDER BY timestamp DESC")
    fun getAttemptsForChapter(chapterId: Int): Flow<List<TestAttemptEntity>>

    @Query("SELECT * FROM test_attempts WHERE attemptId = :attemptId LIMIT 1")
    fun getAttemptById(attemptId: String): Flow<TestAttemptEntity?>

    @Query("SELECT * FROM test_attempts WHERE chapterId = :chapterId AND testType = :testType ORDER BY score DESC, percentage DESC LIMIT 1")
    fun getBestAttemptForTest(chapterId: Int, testType: String): Flow<TestAttemptEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttempt(attempt: TestAttemptEntity)
}

@Database(
    entities = [QuestionEntity::class, StudentSessionEntity::class, TestAttemptEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun studentSessionDao(): StudentSessionDao
    abstract fun attemptDao(): AttemptDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "abhyas_coaching_science.db"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // Pre-populate with initial CBSE Questions
                        CoroutineScope(Dispatchers.IO).launch {
                            val questions = SeedQuestions.loadAllQuestions(context)
                            if (questions.isNotEmpty()) {
                                getDatabase(context).questionDao().insertQuestions(questions)
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
