package com.example.testqrcode.presentation.ui.screen

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.testqrcode.domain.GetTransactionDetailsUseCase
import com.example.testqrcode.domain.model.QrCode
import com.example.testqrcode.presentation.ui.viewmodel.QRScannerViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

@Composable
fun ScanQrScreen(
    navController: NavController,
    getTransactionDetailsUseCase: GetTransactionDetailsUseCase,
    viewModel: QRScannerViewModel,
) {
    val context = LocalContext.current

    // Create QR code content
    val qrContent = "BNI.ID12345678.MERCHANT MOCK TEST.50000"

    // Create a QRCodeWriter instance
    val qrCodeWriter = QRCodeWriter()

    // Generate QR code as a Bitmap
    val qrBitmap: ImageBitmap? = try {
        val bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, 400, 400)
        Bitmap.createBitmap(bitMatrix.width, bitMatrix.height, Bitmap.Config.RGB_565).apply {
            for (x in 0 until bitMatrix.width) {
                for (y in 0 until bitMatrix.height) {
                    setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
                }
            }
        }.asImageBitmap() // Convert Android Bitmap to ImageBitmap
    } catch (e: WriterException) {
        e.printStackTrace()
        null
    }

    qrBitmap?.let { imageBitmap ->
        Image(
            bitmap = imageBitmap,
            contentDescription = "QR Code",
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
        )
    }

    val qrCodeData = "BNI.ID12345678.MERCHANT MOCK TEST.50000".split(".")
    if (qrCodeData.size >= 4) {
        val bank = qrCodeData[0]
        val transactionId = qrCodeData[1]
        val merchantName = qrCodeData[2]
        val amount = qrCodeData[3]

        // Buat instance QrCode
        val qrCode = QrCode(bank, transactionId, merchantName, amount)

        // Lakukan navigasi atau tindakan lainnya dengan informasi QRIS
        navController.navigate("transactionDetail/${qrCode.transactionId}")
    }
}
