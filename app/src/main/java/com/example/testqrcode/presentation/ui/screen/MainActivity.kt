package com.example.testqrcode.presentation.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testqrcode.data.datasource.TransactionDataSource
import com.example.testqrcode.data.datasource.TransactionDataSourceImpl
import com.example.testqrcode.domain.repository.TransactionRepositoryImpl
import com.example.testqrcode.domain.GetTransactionDetailsUseCase
import com.example.testqrcode.domain.repository.TransactionRepository
import com.example.testqrcode.presentation.ui.theme.TestQRCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val transactionDataSource: TransactionDataSource = TransactionDataSourceImpl()
            val transactionRepository: TransactionRepository = TransactionRepositoryImpl(transactionDataSource)
            val getTransactionDetailsUseCase = GetTransactionDetailsUseCase(transactionRepository)
            TestQRCodeTheme {
                AppNavigation(getTransactionDetailsUseCase)
                }
            }
        }
    }

@Composable
fun AppNavigation(getTransactionDetailsUseCase: GetTransactionDetailsUseCase) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("scanQr") {
            ScanQrScreen(
                navController = navController,
                getTransactionDetailsUseCase = getTransactionDetailsUseCase,
                viewModel = viewModel() // QRScannerViewModel instance here
            )
        }
        composable("transactionDetail/{transactionId}") { backStackEntry ->
            val transactionId = backStackEntry.arguments?.getString("transactionId") ?: ""
            TransactionDetailScreen(transactionId, getTransactionDetailsUseCase)
        }
        composable("paymentSuccessful") { PaymentSuccessfulScreen() }
        composable("transactionHistory") { TransactionHistoryScreen() }
    }
}
