package com.example.ui.screens.receipt

import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.util.PdfReceiptGenerator
import com.example.ui.AppViewModel
import com.example.ui.theme.AbhyasAmber
import com.example.ui.theme.AbhyasGreen
import com.example.ui.theme.AbhyasNavy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptScreen(viewModel: AppViewModel) {
    BackHandler {
        viewModel.navigateBack()
    }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val session by viewModel.currentSession.collectAsState()

    var isGeneratingPdf by remember { mutableStateOf(false) }

    val studentSession = session ?: return

    val dateStr = SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.getDefault()).format(Date(studentSession.activationDate))

    fun onDownloadReceipt() {
        scope.launch {
            isGeneratingPdf = true
            val file: File? = withContext(Dispatchers.IO) {
                try {
                    PdfReceiptGenerator.generateReceiptPdf(context, studentSession)
                } catch (e: Exception) {
                    null
                }
            }
            isGeneratingPdf = false
            if (file != null && file.exists()) {
                Toast.makeText(context, "PDF Receipt Generated: ${file.name}", Toast.LENGTH_SHORT).show()
                PdfReceiptGenerator.viewReceiptPdf(context, file)
            } else {
                Toast.makeText(context, "Failed to generate receipt PDF", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onShareReceipt() {
        scope.launch {
            isGeneratingPdf = true
            val file: File? = withContext(Dispatchers.IO) {
                try {
                    PdfReceiptGenerator.generateReceiptPdf(context, studentSession)
                } catch (e: Exception) {
                    null
                }
            }
            isGeneratingPdf = false
            if (file != null && file.exists()) {
                PdfReceiptGenerator.shareReceiptPdf(context, file)
            } else {
                Toast.makeText(context, "Failed to prepare PDF for sharing", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Official Enrolment Receipt", fontSize = 16.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("receipt_back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { onShareReceipt() },
                        modifier = Modifier.testTag("receipt_top_share_button")
                    ) {
                        Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.White)
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Receipt Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("official_receipt_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    // Header inside receipt
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(AbhyasNavy)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "ABHYAS COACHING",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Class 10 Science Test Series",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AbhyasAmber
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Official Enrolment & Fee Receipt",
                                fontSize = 11.5.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Verification Pill
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = AbhyasGreen.copy(alpha = 0.12f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, AbhyasGreen)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Active",
                                tint = AbhyasGreen,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "PAYMENT VERIFIED • LIFETIME OFFLINE ACTIVE",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = AbhyasGreen
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Details
                    ReceiptField(label = "Student Name", value = studentSession.studentName)
                    ReceiptField(label = "Student Email", value = studentSession.studentEmail)
                    ReceiptField(label = "Course Title", value = "Class 10 CBSE Science Test Series")
                    ReceiptField(label = "Amount Paid", value = "${studentSession.paymentAmount} via PhonePe UPI", highlight = true)
                    ReceiptField(label = "Merchant / Payee", value = "${studentSession.payeeName} (PhonePe)")
                    ReceiptField(label = "Transaction / UTR ID", value = studentSession.referenceId, highlight = true)
                    ReceiptField(label = "Backend Sync", value = "Verified via Supabase Cloud")
                    ReceiptField(label = "Issue Date & Time", value = dateStr)
                    ReceiptField(label = "Payment Status", value = "VERIFIED & ACTIVE (FULL PASS)", valueColor = AbhyasGreen)

                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                    Spacer(modifier = Modifier.height(12.dp))

                    // Administration credits
                    Text(
                        text = "ACADEMIC ADMINISTRATION",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = AbhyasNavy
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Given by: Praful Kumar",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Senior Science Faculty",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "Director: Anuj Sir",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Founder Director",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Official Seal badge
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = AbhyasAmber.copy(alpha = 0.1f),
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, AbhyasAmber)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Verified,
                                    contentDescription = "Seal",
                                    tint = AbhyasAmber,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "OFFICIALLY CERTIFIED BY ABHYAS COACHING",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AbhyasAmber
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Real Download & Share Buttons
            Button(
                onClick = { onDownloadReceipt() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .testTag("download_pdf_button"),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AbhyasNavy),
                enabled = !isGeneratingPdf
            ) {
                if (isGeneratingPdf) {
                    CircularProgressIndicator(modifier = Modifier.size(22.dp), color = Color.White, strokeWidth = 2.dp)
                } else {
                    Icon(
                        imageVector = Icons.Default.Download,
                        contentDescription = "Download",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Download / Save PDF Receipt",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = { onShareReceipt() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("share_pdf_button"),
                shape = RoundedCornerShape(12.dp),
                enabled = !isGeneratingPdf
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Share Receipt with Parents / Teacher",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun ReceiptField(
    label: String,
    value: String,
    highlight: Boolean = false,
    valueColor: Color = Color.Unspecified
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 12.5.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            fontSize = if (highlight) 14.5.sp else 12.5.sp,
            fontWeight = if (highlight) FontWeight.ExtraBold else FontWeight.SemiBold,
            color = if (valueColor != Color.Unspecified) valueColor else if (highlight) AbhyasNavy else MaterialTheme.colorScheme.onSurface
        )
    }
}
