package com.example.testqrcode.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testqrcode.domain.GetTransactionDetailsUseCase
import com.example.testqrcode.domain.RecordTransactionUseCase
import com.example.testqrcode.domain.ReduceBalanceUseCase
import com.example.testqrcode.domain.model.Transaction
import com.example.testqrcode.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getTransactionDetailsUseCase: GetTransactionDetailsUseCase,
    private val recordTransactionUseCase: RecordTransactionUseCase,
    private val reduceBalanceUseCase: ReduceBalanceUseCase,
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    suspend fun getTransactionDetails(transactionId: String): Transaction {
        return getTransactionDetailsUseCase.execute(transactionId)
    }

    // Function to record a new transaction
    suspend fun recordTransaction(transaction: Transaction) {
        recordTransactionUseCase.execute(transaction)
    }

    // Function to reduce balance
    suspend fun reduceBalance(amount: Double) {
        reduceBalanceUseCase.execute(amount)
    }
}