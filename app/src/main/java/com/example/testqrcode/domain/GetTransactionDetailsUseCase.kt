package com.example.testqrcode.domain

import com.example.testqrcode.domain.model.QrCode
import com.example.testqrcode.domain.repository.TransactionRepository
import com.example.testqrcode.domain.model.Transaction
import javax.inject.Inject

class GetTransactionDetailsUseCase @Inject constructor(private val transactionRepository: TransactionRepository) {
    suspend fun execute(transactionId: String): Transaction {
        return transactionRepository.getTransactionDetails(transactionId)
    }

    // Tambahan: Metode untuk melakukan pembayaran dan mengurangi saldo
    fun parseQrCode(qrCodeString: String): QrCode {
        val qrCodeParts = qrCodeString.split(".")
        if (qrCodeParts.size != 4) {
            throw IllegalArgumentException("Invalid QR code format")
        }

        val bank = qrCodeParts[0]
        val transactionId = qrCodeParts[1]
        val merchantName = qrCodeParts[2]
        val amount = qrCodeParts[3]

        return QrCode(bank, transactionId, merchantName, amount)
    }
}