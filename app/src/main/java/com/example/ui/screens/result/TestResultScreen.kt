package com.example.ui.screens.result

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.ui.Screen
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasBlue
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import com.example.ui.theme.AbhyasPurple
import com.example.ui.theme.AbhyasRed
import org.json.JSONArray
import org.json.JSONObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestResultScreen(viewModel: AppViewModel) {
    BackHandler {
        viewModel.navigateTo(Screen.Dashboard)
    }

    val attempt by viewModel.viewingAttempt.collectAsState()
    val questions by viewModel.attemptQuestions.collectAsState()
    var filterMode by remember { mutableStateOf("ALL") } // ALL, CORRECT, INCORRECT, UNATTEMPTED

    if (attempt == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { viewModel.navigateTo(Screen.Dashboard) }) {
                Text("Return to Dashboard")
            }
        }
        return
    }

    val att = attempt!!

    // Parse responses map
    val responsesMap = remember(att.responsesJson) {
        val map = mutableMapOf<String, Int>()
        try {
            val json = JSONObject(att.responsesJson)
            val keys = json.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                map[key] = json.getInt(key)
            }
        } catch (e: Exception) {
            // fallback
        }
        map
    }

    val filteredQuestions = remember(filterMode, questions, responsesMap) {
        when (filterMode) {
            "CORRECT" -> questions.filter {
                responsesMap[it.questionId] == it.correctAnswer
            }
            "INCORRECT" -> questions.filter {
                val ans = responsesMap[it.questionId] ?: -1
                ans != -1 && ans != it.correctAnswer
            }
            "UNATTEMPTED" -> questions.filter {
                (responsesMap[it.questionId] ?: -1) == -1
            }
            else -> questions
        }
    }

    val minutes = att.timeUsedSeconds / 60
    val seconds = att.timeUsedSeconds % 60
    val timeUsedStr = "${minutes}m ${seconds}s"

    // CBSE Grade calculation
    val grade = when {
        att.percentage >= 91f -> "A1 (Outstanding)"
        att.percentage >= 81f -> "A2 (Excellent)"
        att.percentage >= 71f -> "B1 (Very Good)"
        att.percentage >= 61f -> "B2 (Good)"
        att.percentage >= 51f -> "C1 (Above Average)"
        att.percentage >= 41f -> "C2 (Average)"
        att.percentage >= 33f -> "D (Pass)"
        else -> "E (Needs Improvement)"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Result & Solutions", fontSize = 16.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateTo(Screen.Dashboard) },
                        modifier = Modifier.testTag("result_back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { viewModel.navigateTo(Screen.Dashboard) },
                        modifier = Modifier.testTag("result_home_button")
                    ) {
                        Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AbhyasNavy,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))

                // Scorecard Summary Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = AbhyasNavy)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = att.testTitle,
                            fontSize = 15.sp,
                            color = Color.White.copy(alpha = 0.85f),
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Score Circle
                        Box(
                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.15f))
                                .border(3.dp, AbhyasAmber, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${att.score}/${att.totalMarks}",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                                Text(
                                    text = "${att.percentage.toInt()}%",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AbhyasAmber
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "CBSE Grade: $grade",
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFDE68A)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Evaluated Locally • Given by: Praful Kumar",
                            fontSize = 11.5.sp,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    }
                }
            }

            // Coin Reward Banner Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = AbhyasAmber.copy(alpha = 0.15f)),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, AbhyasAmber)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(AbhyasAmber),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MonetizationOn,
                                    contentDescription = "Coins Earned",
                                    tint = Color.White,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "+${att.coinsEarned} Abhyas Coins Earned!",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AbhyasNavy
                                )
                                Text(
                                    text = "+10 coins per correct answer + merit bonus",
                                    fontSize = 11.5.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = AbhyasNavy
                        ) {
                            Text(
                                text = "REWARD",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            // Detailed Metrics Grid (Correct, Incorrect, Unattempted, Accuracy, Time Used)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Performance Breakdown",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = AbhyasNavy
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ResultMetricPill(label = "Correct", value = "${att.correctCount}", color = AbhyasGreen)
                            ResultMetricPill(label = "Incorrect", value = "${att.incorrectCount}", color = AbhyasRed)
                            ResultMetricPill(label = "Unattempted", value = "${att.unattemptedCount}", color = MaterialTheme.colorScheme.onSurfaceVariant)
                            ResultMetricPill(label = "Accuracy", value = "${att.accuracy.toInt()}%", color = AbhyasBlue)
                            ResultMetricPill(label = "Time Used", value = timeUsedStr, color = AbhyasPurple)
                        }
                    }
                }
            }

            // Time Management Review Card (समय प्रबंधन विश्लेषण)
            item {
                val totalQ = questions.size.coerceAtLeast(1)
                val avgSecPerQ = (att.timeUsedSeconds / totalQ).coerceAtLeast(1)
                val pacingRating = when {
                    avgSecPerQ <= 75 && att.accuracy >= 70f -> "⚡ Excellent Speed & High Accuracy (आदर्श समय व सटीकता)"
                    avgSecPerQ <= 90 -> "⏱️ Balanced Pacing (संतुलित गति)"
                    else -> "🐢 Slow Pacing (गति अभ्यास की आवश्यकता)"
                }
                val pacingColor = when {
                    avgSecPerQ <= 75 -> AbhyasGreen
                    avgSecPerQ <= 90 -> AbhyasBlue
                    else -> AbhyasAmber
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("result_time_management_card"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, pacingColor.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.AccessTime,
                                    contentDescription = null,
                                    tint = pacingColor,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Time Management Analysis (समय प्रबंधन)",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AbhyasNavy
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = pacingColor.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "${avgSecPerQ}s / Q",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = pacingColor,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = pacingRating,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(10.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "💡 बोर्ड परीक्षा टिप: 1 अंक के प्रत्येक MCQ के लिए 60 से 75 सेकंड का समय आदर्श होता है। छूटे प्रश्नों को मार्क करके अंत में समीक्षा करना सर्वोत्तम रणनीति है।",
                            fontSize = 11.5.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            // Action Buttons Row (Retake, Analytics, Dashboard)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            viewModel.startTest(
                                chapterId = att.chapterId,
                                testType = att.testType,
                                title = att.testTitle
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .testTag("result_retake_button"),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = "Retake", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Retake Test")
                    }

                    Button(
                        onClick = { viewModel.navigateTo(Screen.Performance) },
                        modifier = Modifier
                            .weight(1f)
                            .testTag("result_view_performance_button"),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = AbhyasNavy)
                    ) {
                        Icon(Icons.Default.Analytics, contentDescription = "Analytics", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("All Analytics")
                    }
                }
            }

            // Solutions & Explanations Header and Filters
            item {
                Column {
                    Text(
                        text = "Question Solutions & NCERT Explanations",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = AbhyasNavy
                    )
                    Text(
                        text = "Review step-by-step solutions for deep conceptual clarity",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        val filters = listOf(
                            "ALL" to "All (${questions.size})",
                            "CORRECT" to "Correct (${att.correctCount})",
                            "INCORRECT" to "Incorrect (${att.incorrectCount})",
                            "UNATTEMPTED" to "Unattempted (${att.unattemptedCount})"
                        )
                        items(filters) { (key, label) ->
                            FilterChip(
                                selected = filterMode == key,
                                onClick = { filterMode = key },
                                label = { Text(label, fontSize = 12.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = AbhyasNavy,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }
                }
            }

            // Question Explanations List
            items(filteredQuestions) { q ->
                val chosenIndex = responsesMap[q.questionId] ?: -1
                val isCorrect = chosenIndex == q.correctAnswer
                val isUnattempted = chosenIndex == -1

                SolutionQuestionCard(
                    question = q,
                    chosenIndex = chosenIndex,
                    isCorrect = isCorrect,
                    isUnattempted = isUnattempted
                )
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun SolutionQuestionCard(
    question: com.example.data.model.QuestionEntity,
    chosenIndex: Int,
    isCorrect: Boolean,
    isUnattempted: Boolean
) {
    val optionsList = remember(question.optionsJson) {
        try {
            val arr = JSONArray(question.optionsJson)
            val list = mutableListOf<String>()
            for (i in 0 until arr.length()) {
                list.add(arr.getString(i))
            }
            list
        } catch (e: Exception) {
            listOf("Option A", "Option B", "Option C", "Option D")
        }
    }

    val statusColor = when {
        isUnattempted -> MaterialTheme.colorScheme.onSurfaceVariant
        isCorrect -> AbhyasGreen
        else -> AbhyasRed
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Status row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = statusColor.copy(alpha = 0.15f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = when {
                                isUnattempted -> Icons.Default.AccessTime
                                isCorrect -> Icons.Default.Check
                                else -> Icons.Default.Close
                            },
                            contentDescription = null,
                            tint = statusColor,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = when {
                                isUnattempted -> "Unattempted"
                                isCorrect -> "Correct (+${question.marks})"
                                else -> "Incorrect (0)"
                            },
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = statusColor
                        )
                    }
                }

                Text(
                    text = question.topic,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = question.questionText,
                fontSize = 14.5.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 21.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Options with markers
            optionsList.forEachIndexed { idx, optText ->
                val letter = ('A' + idx)
                val isChosen = chosenIndex == idx
                val isCorrectOpt = question.correctAnswer == idx

                val optBg = when {
                    isCorrectOpt -> AbhyasGreen.copy(alpha = 0.12f)
                    isChosen -> AbhyasRed.copy(alpha = 0.1f)
                    else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                }

                val optBorder = when {
                    isCorrectOpt -> AbhyasGreen
                    isChosen -> AbhyasRed
                    else -> Color.Transparent
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = optBg,
                    border = androidx.compose.foundation.BorderStroke(1.dp, optBorder),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "($letter)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isCorrectOpt) AbhyasGreen else if (isChosen) AbhyasRed else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = optText,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                        if (isCorrectOpt) {
                            Text(
                                text = "Correct Answer",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AbhyasGreen
                            )
                        } else if (isChosen) {
                            Text(
                                text = "Your Answer",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AbhyasRed
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Detailed NCERT Explanation Box
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "NCERT Explanation:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AbhyasNavy
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = question.explanation,
                        fontSize = 12.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ResultMetricPill(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            fontSize = 10.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
