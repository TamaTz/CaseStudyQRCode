package com.example.testqrcode.domain.repository

import com.example.testqrcode.data.datasource.TransactionDataSource
import com.example.testqrcode.domain.model.Transaction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepositoryImpl @Inject constructor(private val dataSource: TransactionDataSource) :
    TransactionRepository {
    override suspend fun getTransactionDetails(transactionId: String): Transaction {
        return dataSource.getTransactionDetails(transactionId)
    }

    override suspend fun recordTransaction(transaction: Transaction) {
        dataSource.recordTransaction(transaction)
    }

    override suspend fun reduceBalance(amount: Double) {
        dataSource.reduceBalance(amount)
    }
}