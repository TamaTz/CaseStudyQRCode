package com.example.testqrcode.data.datasource

import com.example.testqrcode.domain.model.Transaction

class TransactionDataSourceImpl : TransactionDataSource {
    private val transactions : MutableMap<String, Transaction> = mutableMapOf()
    private var  balance: Double = 10000000.0

    override suspend fun getTransactionDetails(transactionId: String): Transaction {
        // Mengambil detail transaksi berdasarkan transactionId dari sumber data
        return transactions[transactionId] ?: throw NoSuchElementException("Transaction Not Found")
    }

    override suspend fun recordTransaction(transaction: Transaction) {
        // Merekam transaksi ke sumber data
       transactions[transaction.id] = transaction
    }

    override suspend fun reduceBalance(amount: Double) {
        // Mengurangi saldo di sumber data
        if (balance >= amount) {
            balance -= amount
        } else {
            throw IllegalArgumentException("Insufficient balance")
        }
    }
}