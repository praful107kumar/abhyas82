package com.example.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.SportsScore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.local.SyllabusData
import com.example.data.model.Chapter
import com.example.ui.AppViewModel
import com.example.ui.Screen
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasBlue
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import com.example.ui.theme.AbhyasPurple
import com.example.ui.theme.AbhyasTeal

@Composable
fun DashboardScreen(viewModel: AppViewModel) {
    val session by viewModel.currentSession.collectAsState()
    val allAttempts by viewModel.allAttempts.collectAsState()
    var selectedSubjectFilter by remember { mutableStateOf("All") }

    val subjects = listOf("All", "Chemistry", "Biology", "Physics", "Natural Resources")

    val filteredChapters = remember(selectedSubjectFilter) {
        if (selectedSubjectFilter == "All") {
            SyllabusData.chapters
        } else {
            SyllabusData.chapters.filter { it.subject == selectedSubjectFilter }
        }
    }

    val totalTestsCount = allAttempts.size
    val totalCoins = session?.coins ?: 0
    val totalCorrect = allAttempts.sumOf { it.correctCount }
    val avgAccuracy = if (allAttempts.isNotEmpty()) {
        allAttempts.map { it.accuracy }.average().toInt()
    } else 0

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))

            // Top Header Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(AbhyasNavy),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_abhyas_icon),
                            contentDescription = "Logo",
                            modifier = Modifier.size(46.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "ABHYAS COACHING",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = AbhyasNavy
                        )
                        Text(
                            text = "Welcome, ${session?.studentName ?: "Student"}",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Coins Wallet Pill
                Surface(
                    onClick = { viewModel.navigateTo(Screen.CoinsWallet) },
                    shape = RoundedCornerShape(20.dp),
                    color = AbhyasAmber.copy(alpha = 0.15f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, AbhyasAmber),
                    modifier = Modifier.testTag("coins_wallet_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.MonetizationOn,
                            contentDescription = "Coins",
                            tint = AbhyasAmber,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "$totalCoins",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = AbhyasNavy
                        )
                    }
                }
            }
        }

        // Quick Navigation Buttons Row (Receipt, Activation QR, Analytics, Logout)
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                QuickNavCard(
                    title = "Receipt",
                    icon = Icons.Default.Description,
                    color = AbhyasBlue,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("nav_receipt_button"),
                    onClick = { viewModel.navigateTo(Screen.Receipt) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                QuickNavCard(
                    title = "QR Pass",
                    icon = Icons.Default.QrCode,
                    color = AbhyasTeal,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("nav_qr_button"),
                    onClick = { viewModel.navigateTo(Screen.ActivationQr) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                QuickNavCard(
                    title = "Analytics",
                    icon = Icons.Default.Analytics,
                    color = AbhyasPurple,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("nav_performance_button"),
                    onClick = { viewModel.navigateTo(Screen.Performance) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                QuickNavCard(
                    title = "Logout",
                    icon = Icons.Default.ExitToApp,
                    color = Color(0xFFDC2626),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("nav_logout_button"),
                    onClick = { viewModel.logout() }
                )
            }
        }

        // Hero Banner Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.hero_science),
                        contentDescription = "Science Hero Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, AbhyasNavy.copy(alpha = 0.95f))
                                )
                            )
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(14.dp)
                    ) {
                        Text(
                            text = "CBSE Class 10 Science Test Series",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Given by: Praful Kumar  •  Director: Anuj Sir",
                            fontSize = 12.sp,
                            color = Color(0xFFFDE68A),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        // Quick Stats Summary Row
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    StatPill(label = "Tests Taken", value = "$totalTestsCount", icon = Icons.Default.SportsScore, color = AbhyasBlue)
                    StatPill(label = "Correct", value = "$totalCorrect", icon = Icons.Default.Bolt, color = AbhyasGreen)
                    StatPill(label = "Accuracy", value = "$avgAccuracy%", icon = Icons.Default.EmojiEvents, color = AbhyasAmber)
                }
            }
        }

        // Full Syllabus Grand Mock Test Banner
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.startTest(
                            chapterId = 0,
                            testType = "FULL_MOCK",
                            title = "CBSE Class 10 Grand Science Mock Test"
                        )
                    }
                    .testTag("grand_mock_test_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = AbhyasNavy)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = AbhyasAmber
                            ) {
                                Text(
                                    text = "BOARD SIMULATION",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Full Syllabus",
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Grand Mock Test (CBSE Pattern)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Comprehensive full textbook evaluation • 60 mins",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Start Grand Mock",
                            tint = Color.White
                        )
                    }
                }
            }
        }

        // Section Title & Subject Filter Chips
        item {
            Column {
                Text(
                    text = "Official CBSE Chapters",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = AbhyasNavy
                )
                Text(
                    text = "All 13 chapters with 100 Questions Each (प्रत्येक अध्याय में 100 प्रश्न • कुल 1300+ प्रश्न)",
                    fontSize = 12.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(subjects) { subject ->
                        FilterChip(
                            selected = selectedSubjectFilter == subject,
                            onClick = { selectedSubjectFilter = subject },
                            label = { Text(subject, fontSize = 13.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = AbhyasNavy,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }
        }

        // Chapter List Cards
        items(filteredChapters) { chapter ->
            ChapterItemCard(
                chapter = chapter,
                attemptsCount = allAttempts.count { it.chapterId == chapter.id },
                onClick = { viewModel.navigateTo(Screen.ChapterDetail(chapter.id)) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun ChapterItemCard(
    chapter: Chapter,
    attemptsCount: Int,
    onClick: () -> Unit
) {
    val subjectColor = when (chapter.subject) {
        "Chemistry" -> AbhyasTeal
        "Biology" -> AbhyasGreen
        "Physics" -> AbhyasBlue
        else -> AbhyasAmber
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("chapter_card_${chapter.id}"),
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = subjectColor.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "Ch ${chapter.number}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = subjectColor,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = chapter.subject,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                Text(
                    text = "$attemptsCount/5 Completed",
                    fontSize = 12.sp,
                    color = if (attemptsCount > 0) AbhyasGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = chapter.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = chapter.description,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Progress bar
            LinearProgressIndicator(
                progress = { (attemptsCount / 5f).coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(CircleShape),
                color = subjectColor,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "100 Questions • 5 Tests (20 Qs) + Mega Test",
                    fontSize = 11.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Open Tests",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AbhyasNavy
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Open",
                        tint = AbhyasNavy,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun QuickNavCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(68.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = color,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun StatPill(
    label: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = color,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = label,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
