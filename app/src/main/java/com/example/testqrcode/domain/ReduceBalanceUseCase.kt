package com.example.testqrcode.domain

import com.example.testqrcode.domain.repository.TransactionRepository
import javax.inject.Inject

class ReduceBalanceUseCase @Inject constructor(private val transactionRepository: TransactionRepository) {
    suspend fun execute(amount: Double) {
        transactionRepository.reduceBalance(amount)
    }
}