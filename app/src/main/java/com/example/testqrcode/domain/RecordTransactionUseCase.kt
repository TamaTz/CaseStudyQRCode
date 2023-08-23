package com.example.testqrcode.domain

import com.example.testqrcode.domain.model.Transaction
import com.example.testqrcode.domain.repository.TransactionRepository
import javax.inject.Inject

class RecordTransactionUseCase @Inject constructor(private val transactionRepository: TransactionRepository) {
    suspend fun execute(transaction: Transaction) {
        transactionRepository.recordTransaction(transaction)
    }
}