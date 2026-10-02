package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.AppViewModel
import com.example.ui.Screen
import com.example.ui.screens.activation.ActivationQrScreen
import com.example.ui.screens.auth.AuthScreen
import com.example.ui.screens.chapter.ChapterDetailScreen
import com.example.ui.screens.dashboard.DashboardScreen
import com.example.ui.screens.payment.PaymentVerificationScreen
import com.example.ui.screens.performance.PerformanceScreen
import com.example.ui.screens.receipt.ReceiptScreen
import com.example.ui.screens.result.TestResultScreen
import com.example.ui.screens.test.TestEngineScreen
import com.example.ui.screens.wallet.CoinsWalletScreen
import com.example.ui.theme.AbhyasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AbhyasTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AbhyasApp()
                }
            }
        }
    }
}

@Composable
fun AbhyasApp(viewModel: AppViewModel = viewModel()) {
    val currentScreen by viewModel.currentScreen.collectAsState()

    when (val screen = currentScreen) {
        is Screen.Auth -> AuthScreen(viewModel)
        is Screen.PaymentVerification -> PaymentVerificationScreen(viewModel)
        is Screen.Dashboard -> DashboardScreen(viewModel)
        is Screen.ChapterDetail -> ChapterDetailScreen(screen.chapterId, viewModel)
        is Screen.TestEngine -> TestEngineScreen(viewModel)
        is Screen.Result -> TestResultScreen(viewModel)
        is Screen.Performance -> PerformanceScreen(viewModel)
        is Screen.ActivationQr -> ActivationQrScreen(viewModel)
        is Screen.Receipt -> ReceiptScreen(viewModel)
        is Screen.CoinsWallet -> CoinsWalletScreen(viewModel)
    }
}
