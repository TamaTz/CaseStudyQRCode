package com.example.testqrcode.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testqrcode.domain.GetTransactionDetailsUseCase

@Composable
fun TransactionDetailScreen(transactionId: String?, getTransactionDetailsUseCase: GetTransactionDetailsUseCase) {
    val typography = Typography()
    val qrCodeString = transactionId ?:  ""
    val qrCode = getTransactionDetailsUseCase.parseQrCode(qrCodeString)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detail Transaksi", style = typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Bank: ${qrCode.bank}", style = typography.bodyMedium)
        Text(text = "ID Transaksi: ${qrCode.transactionId}", style = typography.bodyMedium)
        Text(text = "Merchant: ${qrCode.merchantName}", style = typography.bodyMedium)
        Text(text = "Nominal: ${qrCode.amount}", style = typography.bodyMedium)
    }
}
