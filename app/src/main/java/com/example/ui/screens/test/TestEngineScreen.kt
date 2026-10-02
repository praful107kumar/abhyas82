package com.example.ui.screens.test

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.AppViewModel
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasBlue
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import com.example.ui.theme.AbhyasPurple
import com.example.ui.theme.AbhyasRed
import org.json.JSONArray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestEngineScreen(viewModel: AppViewModel) {
    val questions by viewModel.testQuestions.collectAsState()
    val currentIndex by viewModel.currentQuestionIndex.collectAsState()
    val selectedAnswers by viewModel.selectedAnswers.collectAsState()
    val markedForReview by viewModel.markedForReview.collectAsState()
    val timeRemaining by viewModel.timeRemainingSeconds.collectAsState()
    val totalDuration by viewModel.totalTestDurationSeconds.collectAsState()
    val testTitle by viewModel.testActiveTitle.collectAsState()

    var showPaletteSheet by remember { mutableStateOf(false) }
    var showSubmitDialog by remember { mutableStateOf(false) }
    var showExitWarningDialog by remember { mutableStateOf(false) }

    BackHandler {
        showExitWarningDialog = true
    }

    if (questions.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("No questions found for this test.", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { viewModel.navigateBack() }) {
                    Text("Go Back")
                }
            }
        }
        return
    }

    val currentQuestion = questions.getOrNull(currentIndex) ?: questions[0]
    val currentSelected = selectedAnswers[currentQuestion.questionId]
    val isMarked = markedForReview.contains(currentQuestion.questionId)

    // Time Management calculations
    val answeredCount = selectedAnswers.size
    val unattemptedCount = (questions.size - answeredCount).coerceAtLeast(0)
    val timeProgress = (timeRemaining.toFloat() / totalDuration.coerceAtLeast(1).toFloat()).coerceIn(0f, 1f)
    val timerColor = when {
        timeRemaining < 120 -> AbhyasRed
        timeRemaining < 300 -> AbhyasAmber
        else -> AbhyasGreen
    }
    val avgSecondsPerQ = if (questions.isNotEmpty()) totalDuration / questions.size else 60
    val elapsedSeconds = (totalDuration - timeRemaining).coerceAtLeast(0)
    val expectedAnswered = if (avgSecondsPerQ > 0) (elapsedSeconds / avgSecondsPerQ).coerceAtMost(questions.size) else 0
    val isOnTrack = answeredCount >= expectedAnswered

    // Parse options from JSON
    val optionsList = remember(currentQuestion.optionsJson) {
        try {
            val arr = JSONArray(currentQuestion.optionsJson)
            val list = mutableListOf<String>()
            for (i in 0 until arr.length()) {
                list.add(arr.getString(i))
            }
            list
        } catch (e: Exception) {
            listOf("Option A", "Option B", "Option C", "Option D")
        }
    }

    val hours = timeRemaining / 3600
    val minutes = (timeRemaining % 3600) / 60
    val seconds = timeRemaining % 60
    val timeString = if (hours > 0) {
        String.format("%02d:%02d:%02d", hours, minutes, seconds)
    } else {
        String.format("%02d:%02d", minutes, seconds)
    }
    val isTimerLow = timeRemaining < 300 // under 5 mins

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = testTitle,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                        Text(
                            text = "Question ${currentIndex + 1} of ${questions.size}",
                            fontSize = 11.5.sp,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }
                },
                actions = {
                    // Timer pill
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = if (isTimerLow) AbhyasRed else Color.White.copy(alpha = 0.2f),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = "Time",
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = timeString,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    // Question Palette icon button
                    IconButton(
                        onClick = { showPaletteSheet = true },
                        modifier = Modifier.testTag("question_palette_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.GridView,
                            contentDescription = "Question Palette",
                            tint = Color.White
                        )
                    }

                    // Submit button
                    Button(
                        onClick = { showSubmitDialog = true },
                        colors = ButtonDefaults.buttonColors(containerColor = AbhyasGreen),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .testTag("test_top_submit_button")
                    ) {
                        Text("Submit", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AbhyasNavy,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            // Action navigation bottom bar
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { viewModel.prevQuestion() },
                        enabled = currentIndex > 0,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("test_prev_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Previous",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Previous")
                    }

                    if (currentSelected != null) {
                        TextButton(
                            onClick = { viewModel.clearOption(currentQuestion.questionId) },
                            modifier = Modifier.testTag("test_clear_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear",
                                modifier = Modifier.size(16.dp),
                                tint = AbhyasRed
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Clear", color = AbhyasRed)
                        }
                    }

                    Button(
                        onClick = {
                            if (currentIndex < questions.size - 1) {
                                viewModel.nextQuestion()
                            } else {
                                showSubmitDialog = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = AbhyasNavy),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("test_next_button")
                    ) {
                        Text(if (currentIndex < questions.size - 1) "Next" else "Review & Submit")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = if (currentIndex < questions.size - 1) Icons.AutoMirrored.Filled.ArrowForward else Icons.Default.Done,
                            contentDescription = "Next",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                // Time Management & Pacing Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("time_management_card"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.AccessTime,
                                    contentDescription = null,
                                    tint = timerColor,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Time Left: $timeString",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = timerColor
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (isOnTrack) AbhyasGreen.copy(alpha = 0.15f) else AbhyasAmber.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = if (isOnTrack) "⏱️ On Track (सही गति)" else "⚡ Speed Up (तेज़ करें)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isOnTrack) AbhyasGreen else AbhyasAmber,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Time progress bar
                        LinearProgressIndicator(
                            progress = { timeProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(5.dp)
                                .clip(CircleShape),
                            color = timerColor,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Answered: $answeredCount/${questions.size} • Target: ~${avgSecondsPerQ}s/Q",
                                fontSize = 11.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            if (unattemptedCount > 0) {
                                TextButton(
                                    onClick = { viewModel.jumpToNextUnanswered() },
                                    modifier = Modifier.height(28.dp).testTag("quick_jump_unanswered_button")
                                ) {
                                    Text(
                                        text = "Next Blank ($unattemptedCount) →",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AbhyasBlue
                                    )
                                }
                            }
                        }
                    }
                }
            }

            if (timeRemaining in 1..300) {
                item {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = AbhyasRed.copy(alpha = 0.12f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, AbhyasRed.copy(alpha = 0.5f)),
                        modifier = Modifier.fillMaxWidth().testTag("time_warning_banner")
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "⚠️", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "5 मिनट से कम समय शेष है! छोड़े गए प्रश्नों (Unanswered) की तुरंत समीक्षा करें।",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AbhyasRed
                            )
                        }
                    }
                }
            }

            item {
                // Progress indicator
                LinearProgressIndicator(
                    progress = { (currentIndex + 1).toFloat() / questions.size.toFloat() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(CircleShape),
                    color = AbhyasNavy,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }

            // Question Info Bar (Topic, Marks, Competency, Mark for Review button)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = currentQuestion.questionType,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = AbhyasGreen.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "+${currentQuestion.marks} Mark",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AbhyasGreen,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = AbhyasAmber.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = currentQuestion.difficulty,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AbhyasAmber,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    // Mark for Review toggle
                    Surface(
                        onClick = { viewModel.toggleMarkForReview(currentQuestion.questionId) },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isMarked) AbhyasPurple.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant,
                        border = if (isMarked) androidx.compose.foundation.BorderStroke(1.dp, AbhyasPurple) else null,
                        modifier = Modifier.testTag("mark_for_review_button")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = if (isMarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "Review",
                                tint = if (isMarked) AbhyasPurple else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isMarked) "Marked" else "Review",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isMarked) AbhyasPurple else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // Question Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Topic: ${currentQuestion.topic}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = currentQuestion.questionText,
                            fontSize = 15.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 22.sp
                        )

                        if (currentQuestion.competency.isNotBlank()) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Competency: ${currentQuestion.competency}",
                                fontSize = 11.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Select one correct option:",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Options List
            items(optionsList.size) { optIndex ->
                val optionText = optionsList[optIndex]
                val isSelected = currentSelected == optIndex
                val optionLetter = ('A' + optIndex)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.selectOption(currentQuestion.questionId, optIndex) }
                        .testTag("option_${currentQuestion.questionId}_$optIndex"),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) AbhyasNavy.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surface
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = if (isSelected) 2.dp else 1.dp,
                        color = if (isSelected) AbhyasNavy else MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = { viewModel.selectOption(currentQuestion.questionId, optIndex) },
                            colors = RadioButtonDefaults.colors(selectedColor = AbhyasNavy)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) AbhyasNavy else MaterialTheme.colorScheme.surfaceVariant
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "$optionLetter",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = optionText,
                            fontSize = 14.5.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }

    // Question Palette BottomSheet
    if (showPaletteSheet) {
        ModalBottomSheet(
            onDismissRequest = { showPaletteSheet = false },
            sheetState = rememberModalBottomSheetState()
        ) {
            QuestionPaletteContent(
                questions = questions,
                currentIndex = currentIndex,
                selectedAnswers = selectedAnswers,
                markedForReview = markedForReview,
                onSelectQuestion = { idx ->
                    viewModel.jumpToQuestion(idx)
                    showPaletteSheet = false
                },
                onJumpNextUnanswered = {
                    viewModel.jumpToNextUnanswered()
                    showPaletteSheet = false
                },
                onSubmitClick = {
                    showPaletteSheet = false
                    showSubmitDialog = true
                }
            )
        }
    }

    // Submit Confirmation Dialog
    if (showSubmitDialog) {
        val total = questions.size
        val answered = selectedAnswers.size
        val unattempted = total - answered
        val marked = markedForReview.size

        AlertDialog(
            onDismissRequest = { showSubmitDialog = false },
            title = {
                Text(
                    text = "Submit Test?",
                    fontWeight = FontWeight.Bold,
                    color = AbhyasNavy
                )
            },
            text = {
                Column {
                    Text(
                        text = "Are you sure you want to finish and submit? Your answers will be evaluated immediately offline.",
                        fontSize = 13.5.sp
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Answered:", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                                Text("$answered", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = AbhyasGreen)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Unanswered:", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                                Text("$unattempted", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = AbhyasRed)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Marked for Review:", fontSize = 13.sp, fontWeight = FontWeight.Medium)
                                Text("$marked", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = AbhyasPurple)
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitDialog = false
                        viewModel.submitTest()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = AbhyasGreen),
                    modifier = Modifier.testTag("confirm_submit_test_button")
                ) {
                    Text("Submit Test Now")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitDialog = false }) {
                    Text("Resume Test")
                }
            }
        )
    }

    // Exit Warning Dialog
    if (showExitWarningDialog) {
        AlertDialog(
            onDismissRequest = { showExitWarningDialog = false },
            title = { Text("Quit Test?", fontWeight = FontWeight.Bold) },
            text = {
                Text("Do you want to submit your progress so far, or abandon this test attempt?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showExitWarningDialog = false
                        viewModel.submitTest()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = AbhyasNavy)
                ) {
                    Text("Submit Progress")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showExitWarningDialog = false
                    viewModel.navigateBack()
                }) {
                    Text("Exit Without Saving", color = AbhyasRed)
                }
            }
        )
    }
}

@Composable
fun QuestionPaletteContent(
    questions: List<com.example.data.model.QuestionEntity>,
    currentIndex: Int,
    selectedAnswers: Map<String, Int>,
    markedForReview: Set<String>,
    onSelectQuestion: (Int) -> Unit,
    onJumpNextUnanswered: () -> Unit = {},
    onSubmitClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Question Palette",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = AbhyasNavy
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Legend
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PaletteLegendItem(color = AbhyasGreen, label = "Answered")
            PaletteLegendItem(color = MaterialTheme.colorScheme.surfaceVariant, label = "Not Attempted")
            PaletteLegendItem(color = AbhyasPurple, label = "Review")
        }

        val unattemptedCount = questions.size - selectedAnswers.size
        if (unattemptedCount > 0) {
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onJumpNextUnanswered,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .testTag("palette_jump_unanswered_button"),
                colors = ButtonDefaults.buttonColors(containerColor = AbhyasAmber, contentColor = AbhyasNavy),
                shape = RoundedCornerShape(10.dp)
            ) {
                Icon(Icons.Default.AccessTime, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Jump to Next Blank ($unattemptedCount Remaining)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.height(240.dp)
        ) {
            itemsIndexed(questions) { idx, q ->
                val isAnswered = selectedAnswers.containsKey(q.questionId)
                val isMarked = markedForReview.contains(q.questionId)
                val isCurrent = idx == currentIndex

                val bgColor = when {
                    isMarked -> AbhyasPurple
                    isAnswered -> AbhyasGreen
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }

                val textColor = if (isAnswered || isMarked) Color.White else MaterialTheme.colorScheme.onSurfaceVariant

                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(bgColor)
                        .border(
                            width = if (isCurrent) 2.5.dp else 0.dp,
                            color = if (isCurrent) AbhyasNavy else Color.Transparent,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable { onSelectQuestion(idx) }
                        .testTag("palette_item_$idx"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${idx + 1}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSubmitClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AbhyasGreen),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Finish & Submit Test", fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PaletteLegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(color)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = label, fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
