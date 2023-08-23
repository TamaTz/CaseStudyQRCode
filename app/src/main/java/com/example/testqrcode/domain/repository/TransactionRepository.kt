package com.example.testqrcode.domain.repository

import com.example.testqrcode.domain.model.Transaction

interface TransactionRepository {
    // Tambahan: Metode untuk merekam transaksi dan mengurangi saldo
    suspend fun getTransactionDetails(transactionId: String): Transaction
    suspend fun recordTransaction(transaction: Transaction)
    suspend fun reduceBalance(amount: Double)
}