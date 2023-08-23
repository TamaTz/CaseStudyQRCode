package com.example.testqrcode.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testqrcode.domain.model.TransactionHistory

val dummyTransactionHistory = listOf(
    TransactionHistory("Merchant A", 10000.0),
    TransactionHistory("Merchant B", 15000.0),
    TransactionHistory("Merchant C", 20000.0),
)

@Composable
fun TransactionHistoryScreen() {
    // Tampilan untuk halaman histori transaksi
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Histori Transaksi",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )

            // Menampilkan daftar histori transaksi menggunakan LazyColumn
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                items(dummyTransactionHistory){ TransactionHistory ->
                    Text(text = "Merchant: ${TransactionHistory.merchantName}, Amount: ${TransactionHistory.amount}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
            Button(
                onClick = { /* Navigasi kembali */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            ) {
                Text(text = "Kembali")
            }
        }
    }
}