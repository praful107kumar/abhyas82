package com.example.ui.screens.activation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Security
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.util.QrMatrixGenerator
import com.example.ui.AppViewModel
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import com.example.ui.theme.AbhyasRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivationQrScreen(viewModel: AppViewModel) {
    BackHandler {
        viewModel.navigateBack()
    }

    val session by viewModel.currentSession.collectAsState()
    val secondsLeft by viewModel.qrSecondsLeft.collectAsState()
    val isExpired by viewModel.isQrExpired.collectAsState()
    val currentToken by viewModel.currentQrToken.collectAsState()

    val qrBitmap = remember(currentToken) {
        QrMatrixGenerator.generateQrBitmap(if (currentToken.isNotBlank()) currentToken else "ABHYAS-PASS-DEMO", 512)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student QR Activation Pass", fontSize = 16.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("qr_back_button")
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ABHYAS COACHING",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = AbhyasNavy
                    )
                    Text(
                        text = "Class 10 Science Test Series Pass",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Given by: Praful Kumar • Director: Anuj Sir",
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = AbhyasGreen.copy(alpha = 0.15f)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Active",
                                tint = AbhyasGreen,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Student Pass Activated (Offline Lifetime)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = AbhyasGreen
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // QR Code Display Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("qr_card_container"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(240.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(
                                width = 3.dp,
                                color = if (isExpired) AbhyasRed else AbhyasNavy,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            bitmap = qrBitmap.asImageBitmap(),
                            contentDescription = "Offline Student QR Pass",
                            modifier = Modifier
                                .size(210.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )

                        // When expired: show prominent QR EXPIRED overlay
                        if (isExpired) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black.copy(alpha = 0.85f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(
                                        imageVector = Icons.Default.Error,
                                        contentDescription = "Expired",
                                        tint = AbhyasRed,
                                        modifier = Modifier.size(44.dp)
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = "QR EXPIRED",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White,
                                        letterSpacing = 1.sp
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "60-second validity ended",
                                        fontSize = 11.5.sp,
                                        color = Color.White.copy(alpha = 0.75f)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Countdown Timer Pill
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = if (isExpired) AbhyasRed.copy(alpha = 0.15f) else AbhyasAmber.copy(alpha = 0.15f)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = null,
                                tint = if (isExpired) AbhyasRed else AbhyasNavy,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isExpired) "QR EXPIRED" else "Token Refresh in ${secondsLeft}s",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isExpired) AbhyasRed else AbhyasNavy
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.refreshQrToken() },
                        colors = ButtonDefaults.buttonColors(containerColor = AbhyasNavy),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .testTag("regenerate_qr_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Regenerate",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isExpired) "Regenerate QR Token" else "Refresh Token Now",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Student Information details card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Student Credentials",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = AbhyasNavy
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    QrDetailRow(label = "Student Name", value = session?.studentName ?: "Praful Kumar")
                    QrDetailRow(label = "Student Email", value = session?.studentEmail ?: "praffulkumar4321@gmail.com")
                    QrDetailRow(label = "Payee / Merchant", value = "${session?.payeeName ?: "Mrs CHANDA DEVI"} (PhonePe)")
                    QrDetailRow(label = "Verified Transaction ID", value = session?.referenceId?.ifBlank { "PENDING" } ?: "PENDING")
                    QrDetailRow(label = "Backend Sync", value = "Connected (Supabase Cloud)")
                    QrDetailRow(
                        label = "Token Hash",
                        value = currentToken.take(24) + "...",
                        isMonospace = true
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun QrDetailRow(label: String, value: String, isMonospace: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
            fontFamily = if (isMonospace) FontFamily.Monospace else FontFamily.Default
        )
    }
}
