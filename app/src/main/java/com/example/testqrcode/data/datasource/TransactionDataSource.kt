package com.example.testqrcode.data.datasource

import com.example.testqrcode.domain.model.Transaction

interface TransactionDataSource {
    suspend fun getTransactionDetails(transactionId: String): Transaction
    suspend fun recordTransaction(transaction: Transaction)
    suspend fun reduceBalance(amount: Double)
}