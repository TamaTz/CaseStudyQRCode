package com.example.testqrcode.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testqrcode.domain.model.QrCode

class QRScannerViewModel : ViewModel() {
    private val _scannedQRData = MutableLiveData<QrCode?>()
    val scannedQRData: LiveData<QrCode?> = _scannedQRData

    fun processQRString(qrString: String) {
        val dataBlocks = qrString.split(".")
        if (dataBlocks.size >= 4) {
            val bank = dataBlocks[0]
            val transactionId = dataBlocks[1]
            val merchantName = dataBlocks[2]
            val amount = dataBlocks[3]

            val qrData = QrCode(bank, transactionId, merchantName, amount)
            _scannedQRData.value = qrData
        }
    }
}
