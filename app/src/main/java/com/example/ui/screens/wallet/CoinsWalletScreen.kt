package com.example.ui.screens.wallet

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import com.example.ui.AppViewModel
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasBlue
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import com.example.ui.theme.AbhyasPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinsWalletScreen(viewModel: AppViewModel) {
    BackHandler {
        viewModel.navigateBack()
    }

    val session by viewModel.currentSession.collectAsState()
    val allAttempts by viewModel.allAttempts.collectAsState()
    val currentCoins = session?.coins ?: 0

    // Determine Rank
    val (rankName, nextGoal, rankIcon) = when {
        currentCoins >= 1000 -> Triple("Abhyas Star Scientist", 2000, Icons.Default.MilitaryTech)
        currentCoins >= 600 -> Triple("Science Topper", 1000, Icons.Default.EmojiEvents)
        currentCoins >= 300 -> Triple("Lab Scholar", 600, Icons.Default.Science)
        currentCoins >= 100 -> Triple("Junior Chemist / Physicist", 300, Icons.Default.Star)
        else -> Triple("Novice Apprentice", 100, Icons.Default.Science)
    }

    val badges = listOf(
        BadgeItem("Welcome Scholar", "Enrolled in Abhyas Coaching Test Series", 100, currentCoins >= 100),
        BadgeItem("Science Explorer", "Completed tests and earned 300 coins", 300, currentCoins >= 300),
        BadgeItem("Concept Master", "Scored high marks and reached 600 coins", 600, currentCoins >= 600),
        BadgeItem("CBSE Topper", "Achieved elite status with 1000+ coins", 1000, currentCoins >= 1000)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Abhyas Coins & Rewards", fontSize = 16.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("coins_back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
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

                // Wallet Balance Banner Card
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
                            text = "STUDENT COIN WALLET",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = AbhyasAmber,
                            letterSpacing = 1.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Box(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)
                                .background(AbhyasAmber.copy(alpha = 0.2f))
                                .border(2.5.dp, AbhyasAmber, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.MonetizationOn,
                                contentDescription = "Coins",
                                tint = AbhyasAmber,
                                modifier = Modifier.size(54.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "$currentCoins Coins",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color.White.copy(alpha = 0.15f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = rankIcon,
                                    contentDescription = null,
                                    tint = AbhyasAmber,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Rank: $rankName",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Progress to next goal
                        val progressFraction = (currentCoins.toFloat() / nextGoal.toFloat()).coerceIn(0f, 1f)
                        LinearProgressIndicator(
                            progress = { progressFraction },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(CircleShape),
                            color = AbhyasAmber,
                            trackColor = Color.White.copy(alpha = 0.2f)
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "$currentCoins / $nextGoal coins to next tier milestone",
                            fontSize = 11.5.sp,
                            color = Color.White.copy(alpha = 0.75f)
                        )
                    }
                }
            }

            // How to Earn Coins Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "How Coins Are Rewarded",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = AbhyasNavy
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        RewardRuleItem(
                            title = "+10 Coins per Correct Answer",
                            desc = "Rewarded immediately upon finishing any practice, chapter or revision test."
                        )
                        RewardRuleItem(
                            title = "+25 Bonus Coins for ≥80% Score",
                            desc = "Merit bonus for excelling in conceptual mastery."
                        )
                        RewardRuleItem(
                            title = "+50 Grand Bonus for 100% Perfect Score",
                            desc = "Top scholastic excellence reward for flawless performance."
                        )
                        RewardRuleItem(
                            title = "+200 Welcome Coins",
                            desc = "Granted upon enrollment and starting the Science Test Series."
                        )
                    }
                }
            }

            // Achievement Badges Section
            item {
                Text(
                    text = "Achievement Badges",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = AbhyasNavy
                )
            }

            items(badges) { badge ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (badge.isUnlocked) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = if (badge.isUnlocked) 1.dp else 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(
                                    if (badge.isUnlocked) AbhyasAmber.copy(alpha = 0.2f) else Color.LightGray.copy(alpha = 0.4f)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (badge.isUnlocked) Icons.Default.CheckCircle else Icons.Default.Lock,
                                contentDescription = null,
                                tint = if (badge.isUnlocked) AbhyasAmber else Color.Gray,
                                modifier = Modifier.size(22.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = badge.title,
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (badge.isUnlocked) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = badge.description,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (badge.isUnlocked) AbhyasGreen.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = if (badge.isUnlocked) "UNLOCKED" else "${badge.requiredCoins} COINS",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (badge.isUnlocked) AbhyasGreen else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
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

@Composable
fun RewardRuleItem(title: String, desc: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = Icons.Default.MonetizationOn,
            contentDescription = null,
            tint = AbhyasAmber,
            modifier = Modifier
                .size(18.dp)
                .padding(top = 2.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = title,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = desc,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

data class BadgeItem(
    val title: String,
    val description: String,
    val requiredCoins: Int,
    val isUnlocked: Boolean
)
