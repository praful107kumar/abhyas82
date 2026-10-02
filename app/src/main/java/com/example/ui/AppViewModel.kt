package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.SyllabusData
import com.example.data.model.Chapter
import com.example.data.model.QuestionEntity
import com.example.data.model.StudentSessionEntity
import com.example.data.model.TestAttemptEntity
import com.example.data.model.TestType
import com.example.data.repository.AuthRepository
import com.example.data.repository.AuthResult
import com.example.data.repository.TestRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.util.UUID

sealed class Screen {
    object Auth : Screen()
    object PaymentVerification : Screen()
    object Dashboard : Screen()
    data class ChapterDetail(val chapterId: Int) : Screen()
    data class TestEngine(val chapterId: Int, val testType: String, val title: String) : Screen()
    data class Result(val attemptId: String) : Screen()
    object Performance : Screen()
    object ActivationQr : Screen()
    object Receipt : Screen()
    object CoinsWallet : Screen()
}

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    private val authRepo = AuthRepository(db.studentSessionDao())
    private val testRepo = TestRepository(db.questionDao(), db.attemptDao(), db.studentSessionDao())

    val currentSession: StateFlow<StudentSessionEntity?> = authRepo.currentSession
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val allAttempts: StateFlow<List<TestAttemptEntity>> = testRepo.allAttempts
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _screenStack = MutableStateFlow<List<Screen>>(listOf(Screen.Dashboard))
    val currentScreen: StateFlow<Screen> = MutableStateFlow<Screen>(Screen.Dashboard).apply {
        viewModelScope.launch {
            _screenStack.collect { stack ->
                value = stack.lastOrNull() ?: Screen.Dashboard
            }
        }
    }

    // Auth screen state
    val authError = MutableStateFlow<String?>(null)
    val isAuthLoading = MutableStateFlow(false)

    // Payment verification state
    val isVerifyingPayment = MutableStateFlow(false)
    val paymentVerificationError = MutableStateFlow<String?>(null)

    // Active Test Engine state
    private val _testQuestions = MutableStateFlow<List<QuestionEntity>>(emptyList())
    val testQuestions = _testQuestions.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex = _currentQuestionIndex.asStateFlow()

    private val _selectedAnswers = MutableStateFlow<Map<String, Int>>(emptyMap())
    val selectedAnswers = _selectedAnswers.asStateFlow()

    private val _markedForReview = MutableStateFlow<Set<String>>(emptySet())
    val markedForReview = _markedForReview.asStateFlow()

    private val _timeRemainingSeconds = MutableStateFlow(0)
    val timeRemainingSeconds = _timeRemainingSeconds.asStateFlow()

    private val _totalTestDurationSeconds = MutableStateFlow(1200)
    val totalTestDurationSeconds = _totalTestDurationSeconds.asStateFlow()

    private val _testActiveChapterId = MutableStateFlow(1)
    val testActiveChapterId = _testActiveChapterId.asStateFlow()

    private val _testActiveType = MutableStateFlow("PRACTICE")
    val testActiveType = _testActiveType.asStateFlow()

    private val _testActiveTitle = MutableStateFlow("Practice Test")
    val testActiveTitle = _testActiveTitle.asStateFlow()

    private var timerJob: Job? = null

    // Latest Result state
    private val _viewingAttempt = MutableStateFlow<TestAttemptEntity?>(null)
    val viewingAttempt = _viewingAttempt.asStateFlow()

    private val _attemptQuestions = MutableStateFlow<List<QuestionEntity>>(emptyList())
    val attemptQuestions = _attemptQuestions.asStateFlow()

    // Activation QR state
    private val _qrSecondsLeft = MutableStateFlow(60)
    val qrSecondsLeft = _qrSecondsLeft.asStateFlow()

    private val _isQrExpired = MutableStateFlow(false)
    val isQrExpired = _isQrExpired.asStateFlow()

    private val _currentQrToken = MutableStateFlow("")
    val currentQrToken = _currentQrToken.asStateFlow()

    private var qrTimerJob: Job? = null

    init {
        viewModelScope.launch {
            testRepo.ensureQuestionsSeeded(getApplication())
            // Ensure student session is active so app opens directly to Dashboard
            val session = authRepo.ensureDefaultSession("Praful Kumar", "praffulkumar4321@gmail.com")
            _screenStack.value = listOf(Screen.Dashboard)
            refreshQrToken(session)
        }
    }

    fun navigateTo(screen: Screen) {
        val currentList = _screenStack.value.toMutableList()
        // Prevent duplicate top
        if (currentList.lastOrNull() != screen) {
            currentList.add(screen)
            _screenStack.value = currentList
        }
    }

    fun navigateBack(): Boolean {
        val currentList = _screenStack.value.toMutableList()
        if (currentList.size > 1) {
            currentList.removeAt(currentList.lastIndex)
            _screenStack.value = currentList
            return true
        }
        return false
    }

    fun skipToDashboard() {
        viewModelScope.launch {
            val session = authRepo.ensureDefaultSession("Praful Kumar", "praffulkumar4321@gmail.com")
            _screenStack.value = listOf(Screen.Dashboard)
            refreshQrToken(session)
        }
    }

    fun login(email: String, pass: String) {
        viewModelScope.launch {
            isAuthLoading.value = true
            authError.value = null
            delay(300) // Brief smooth interaction
            when (val result = authRepo.login(email, pass)) {
                is AuthResult.Success -> {
                    isAuthLoading.value = false
                    _screenStack.value = listOf(Screen.Dashboard)
                    refreshQrToken(result.session)
                }
                is AuthResult.Error -> {
                    isAuthLoading.value = false
                    authError.value = result.message
                }
            }
        }
    }

    fun register(name: String, email: String, pass: String) {
        viewModelScope.launch {
            isAuthLoading.value = true
            authError.value = null
            delay(300)
            when (val result = authRepo.register(name, email, pass)) {
                is AuthResult.Success -> {
                    isAuthLoading.value = false
                    _screenStack.value = listOf(Screen.Dashboard)
                    refreshQrToken(result.session)
                }
                is AuthResult.Error -> {
                    isAuthLoading.value = false
                    authError.value = result.message
                }
            }
        }
    }

    fun verifyPayment(transactionId: String) {
        val session = currentSession.value ?: return
        viewModelScope.launch {
            isVerifyingPayment.value = true
            paymentVerificationError.value = null
            delay(500) // Visual confirmation
            when (val result = authRepo.verifyAndActivate(session, transactionId)) {
                is com.example.data.remote.SupabaseResult.Success -> {
                    isVerifyingPayment.value = false
                    refreshQrToken(session.copy(isActivated = true, referenceId = result.transactionId))
                    _screenStack.value = listOf(Screen.Dashboard)
                }
                is com.example.data.remote.SupabaseResult.Error -> {
                    isVerifyingPayment.value = false
                    paymentVerificationError.value = result.errorMessage
                }
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepo.logout()
            _screenStack.value = listOf(Screen.Auth)
        }
    }

    fun startTest(chapterId: Int, testType: String, title: String) {
        viewModelScope.launch {
            _testActiveChapterId.value = chapterId
            _testActiveType.value = testType
            _testActiveTitle.value = title

            // Load questions offline from Room
            val questions = when {
                testType == "FULL_MOCK" -> testRepo.getFullMockQuestions().firstOrNull() ?: emptyList()
                testType == "ALL_100" || testType == "CHAPTER_ALL" || testType == "ALL_30" -> testRepo.getQuestionsForChapter(chapterId).firstOrNull() ?: emptyList()
                else -> {
                    val list = testRepo.getQuestionsForTest(chapterId, testType).firstOrNull() ?: emptyList()
                    if (list.isEmpty()) {
                        // Fallback to chapter questions if specific test has fewer
                        testRepo.getQuestionsForChapter(chapterId).firstOrNull() ?: emptyList()
                    } else {
                        list
                    }
                }
            }

            _testQuestions.value = questions
            _currentQuestionIndex.value = 0
            _selectedAnswers.value = emptyMap()
            _markedForReview.value = emptySet()

            // Calculate duration in seconds (Generous CBSE MCQ time management)
            val durationMinutes = when (testType) {
                "PRACTICE" -> 20
                "TEST_1" -> 25
                "TEST_2" -> 25
                "TEST_3" -> 25
                "REVISION" -> 20
                "ALL_100", "CHAPTER_ALL", "ALL_30" -> 90
                "FULL_MOCK" -> 30
                else -> 25
            }
            val totalSeconds = durationMinutes * 60
            _totalTestDurationSeconds.value = totalSeconds
            _timeRemainingSeconds.value = totalSeconds

            startTestTimer()
            navigateTo(Screen.TestEngine(chapterId, testType, title))
        }
    }

    fun jumpToNextUnanswered() {
        val questions = _testQuestions.value
        val answers = _selectedAnswers.value
        val currentIndex = _currentQuestionIndex.value
        if (questions.isEmpty()) return
        for (i in (currentIndex + 1) until questions.size) {
            if (!answers.containsKey(questions[i].questionId)) {
                _currentQuestionIndex.value = i
                return
            }
        }
        for (i in 0 until currentIndex) {
            if (!answers.containsKey(questions[i].questionId)) {
                _currentQuestionIndex.value = i
                return
            }
        }
    }

    private fun startTestTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_timeRemainingSeconds.value > 0) {
                delay(1000)
                _timeRemainingSeconds.value = _timeRemainingSeconds.value - 1
            }
            // Timer expired: auto-submit test
            submitTest()
        }
    }

    fun selectOption(questionId: String, optionIndex: Int) {
        val map = _selectedAnswers.value.toMutableMap()
        map[questionId] = optionIndex
        _selectedAnswers.value = map
    }

    fun clearOption(questionId: String) {
        val map = _selectedAnswers.value.toMutableMap()
        map.remove(questionId)
        _selectedAnswers.value = map
    }

    fun toggleMarkForReview(questionId: String) {
        val set = _markedForReview.value.toMutableSet()
        if (set.contains(questionId)) {
            set.remove(questionId)
        } else {
            set.add(questionId)
        }
        _markedForReview.value = set
    }

    fun jumpToQuestion(index: Int) {
        if (index in 0 until _testQuestions.value.size) {
            _currentQuestionIndex.value = index
        }
    }

    fun nextQuestion() {
        if (_currentQuestionIndex.value < _testQuestions.value.size - 1) {
            _currentQuestionIndex.value = _currentQuestionIndex.value + 1
        }
    }

    fun prevQuestion() {
        if (_currentQuestionIndex.value > 0) {
            _currentQuestionIndex.value = _currentQuestionIndex.value - 1
        }
    }

    fun submitTest() {
        timerJob?.cancel()
        val questions = _testQuestions.value
        val answers = _selectedAnswers.value
        val totalQuestions = questions.size

        var correctCount = 0
        var incorrectCount = 0
        var unattemptedCount = 0
        var totalScore = 0
        var maxMarks = 0

        val responsesObj = JSONObject()

        for (q in questions) {
            maxMarks += q.marks
            val selected = answers[q.questionId]
            if (selected == null) {
                unattemptedCount++
                responsesObj.put(q.questionId, -1)
            } else {
                responsesObj.put(q.questionId, selected)
                if (selected == q.correctAnswer) {
                    correctCount++
                    totalScore += q.marks
                } else {
                    incorrectCount++
                }
            }
        }

        if (maxMarks == 0) maxMarks = 1
        val percentage = (totalScore.toFloat() / maxMarks.toFloat()) * 100f
        val attempted = correctCount + incorrectCount
        val accuracy = if (attempted > 0) (correctCount.toFloat() / attempted.toFloat()) * 100f else 0f

        val totalTimeMinutes = when (_testActiveType.value) {
            "PRACTICE" -> 20
            "TEST_1" -> 25
            "TEST_2" -> 25
            "TEST_3" -> 25
            "REVISION" -> 20
            "ALL_100", "CHAPTER_ALL", "ALL_30" -> 90
            "FULL_MOCK" -> 30
            else -> 25
        }
        val timeUsedSeconds = (totalTimeMinutes * 60) - _timeRemainingSeconds.value

        // Coin Reward Calculation:
        // +10 coins per correct answer
        // +25 coins bonus for scoring >= 80%
        // +50 coins bonus for scoring 100%
        var coinsEarned = correctCount * 10
        if (percentage >= 100f) {
            coinsEarned += 50
        } else if (percentage >= 80f) {
            coinsEarned += 25
        }

        val session = currentSession.value
        val studentId = session?.studentId ?: "anonymous_student"

        val attempt = TestAttemptEntity(
            attemptId = UUID.randomUUID().toString(),
            studentId = studentId,
            chapterId = _testActiveChapterId.value,
            testType = _testActiveType.value,
            testTitle = _testActiveTitle.value,
            score = totalScore,
            totalMarks = maxMarks,
            percentage = percentage,
            correctCount = correctCount,
            incorrectCount = incorrectCount,
            unattemptedCount = unattemptedCount,
            accuracy = accuracy,
            timeUsedSeconds = timeUsedSeconds.toLong().coerceAtLeast(1L),
            coinsEarned = coinsEarned,
            timestamp = System.currentTimeMillis(),
            responsesJson = responsesObj.toString()
        )

        viewModelScope.launch {
            testRepo.submitAttempt(attempt)
            _viewingAttempt.value = attempt
            _attemptQuestions.value = questions
            navigateTo(Screen.Result(attempt.attemptId))
        }
    }

    fun viewPastAttempt(attempt: TestAttemptEntity) {
        viewModelScope.launch {
            val questions = if (attempt.testType == "FULL_MOCK") {
                testRepo.getFullMockQuestions().firstOrNull() ?: emptyList()
            } else {
                testRepo.getQuestionsForChapter(attempt.chapterId).firstOrNull() ?: emptyList()
            }
            _viewingAttempt.value = attempt
            _attemptQuestions.value = questions
            navigateTo(Screen.Result(attempt.attemptId))
        }
    }

    fun refreshQrToken(session: StudentSessionEntity? = currentSession.value) {
        qrTimerJob?.cancel()
        _isQrExpired.value = false
        _qrSecondsLeft.value = 60
        val token = "ABHYAS-PASS-${session?.studentId?.take(8) ?: "STDNT"}-${System.currentTimeMillis()}"
        _currentQrToken.value = token

        qrTimerJob = viewModelScope.launch {
            while (_qrSecondsLeft.value > 0) {
                delay(1000)
                _qrSecondsLeft.value = _qrSecondsLeft.value - 1
            }
            _isQrExpired.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
        qrTimerJob?.cancel()
    }
}
