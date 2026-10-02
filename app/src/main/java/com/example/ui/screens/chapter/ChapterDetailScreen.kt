package com.example.ui.screens.chapter

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.SyllabusData
import com.example.data.model.TestType
import com.example.ui.AppViewModel
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasBlue
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import com.example.ui.theme.AbhyasPurple
import com.example.ui.theme.AbhyasTeal

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ChapterDetailScreen(
    chapterId: Int,
    viewModel: AppViewModel
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val chapter = SyllabusData.chapters.firstOrNull { it.id == chapterId }
        ?: SyllabusData.chapters.first()

    val allAttempts by viewModel.allAttempts.collectAsState()
    val chapterAttempts = allAttempts.filter { it.chapterId == chapterId }

    val testCards = listOf(
        TestCardData(
            testType = TestType.PRACTICE,
            tag = "practice_test",
            icon = Icons.Default.Science,
            color = AbhyasTeal,
            highlight = "FOUNDATION PRACTICE"
        ),
        TestCardData(
            testType = TestType.TEST_1,
            tag = "test_1",
            icon = Icons.Default.Assignment,
            color = AbhyasBlue,
            highlight = "STANDARD ASSESSMENT"
        ),
        TestCardData(
            testType = TestType.TEST_2,
            tag = "test_2",
            icon = Icons.Default.Psychology,
            color = AbhyasPurple,
            highlight = "HOTS & COMPETENCY"
        ),
        TestCardData(
            testType = TestType.TEST_3,
            tag = "test_3",
            icon = Icons.Default.EmojiEvents,
            color = AbhyasAmber,
            highlight = "BOARD PATTERN & A/R"
        ),
        TestCardData(
            testType = TestType.REVISION,
            tag = "revision_test",
            icon = Icons.Default.Refresh,
            color = AbhyasGreen,
            highlight = "RAPID REVISION BOOSTER"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Chapter ${chapter.number}: ${chapter.title}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("chapter_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
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

                // Chapter Overview Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = AbhyasNavy.copy(alpha = 0.1f)
                            ) {
                                Text(
                                    text = "Class 10 CBSE Science • ${chapter.subject}",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = AbhyasNavy,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = chapter.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = chapter.description,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 18.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Key Syllabus Topics:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            chapter.keyTopics.forEach { topic ->
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                ) {
                                    Text(
                                        text = topic,
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item {
                // Mega Test: All 100 Questions of this Chapter
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("all_100_questions_test_card"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = AbhyasNavy),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = AbhyasAmber
                            ) {
                                Text(
                                    text = "100 QUESTIONS • सम्पूर्ण अध्याय महा-टेस्ट",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = AbhyasNavy,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.AccessTime,
                                    contentDescription = null,
                                    tint = Color.White.copy(alpha = 0.85f),
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "90 mins",
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Full Chapter Mega Challenge (All 100 Questions)",
                            fontSize = 16.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "इस अध्याय के सभी 100 प्रश्न एक साथ हल करें • टाइमर व समय प्रबंधन के साथ",
                            fontSize = 12.5.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Button(
                            onClick = {
                                viewModel.startTest(chapterId, "ALL_100", "${chapter.title} - Full 100 Questions Challenge")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .testTag("start_all_100_test_button"),
                            colors = ButtonDefaults.buttonColors(containerColor = AbhyasAmber, contentColor = AbhyasNavy),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Start All 100 Questions Test (सभी 100 प्रश्न • 90 मिनट)", fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Prescribed Chapter Tests (5 Tests • 20 Questions Each)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = AbhyasNavy
                )
                Text(
                    text = "Attempt completely offline anytime with timer & question palette (कुल 100 प्रश्न)",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // 5 Test Cards
            items(testCards.size) { index ->
                val cardData = testCards[index]
                val test = cardData.testType
                val bestAttempt = chapterAttempts
                    .filter { it.testType == test.id }
                    .maxByOrNull { it.score }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(cardData.tag),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = cardData.color.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = cardData.highlight,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = cardData.color,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.AccessTime,
                                    contentDescription = "Time",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${test.durationMinutes} mins",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(CircleShape)
                                    .background(cardData.color.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = cardData.icon,
                                    contentDescription = test.title,
                                    tint = cardData.color,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = test.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = test.description,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        if (bestAttempt != null) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = AbhyasGreen.copy(alpha = 0.1f)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp, vertical = 6.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = "Attempted",
                                            tint = AbhyasGreen,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "Best: ${bestAttempt.score}/${bestAttempt.totalMarks} (${bestAttempt.percentage.toInt()}%)",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = AbhyasGreen
                                        )
                                    }
                                    Text(
                                        text = "+${bestAttempt.coinsEarned} coins earned",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = AbhyasAmber
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Button(
                            onClick = {
                                viewModel.startTest(
                                    chapterId = chapter.id,
                                    testType = test.id,
                                    title = "${chapter.title} - ${test.title}"
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                                .testTag("start_test_button_${test.id}"),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = AbhyasNavy)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Start",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (bestAttempt != null) "Retake Test" else "Start Test",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

data class TestCardData(
    val testType: TestType,
    val tag: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val color: Color,
    val highlight: String
)
