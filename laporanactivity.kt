package com.example.pharmaticadmin.laporan

import android.content.Intent
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.pharmaticadmin.R
import java.io.File
import java.io.FileOutputStream

class LaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        val btnCetak =
            findViewById<Button>(R.id.btnCetak)

        btnCetak.setOnClickListener {

            try {

                val pdfDocument =
                    PdfDocument()

                val pageInfo =
                    PdfDocument.PageInfo.Builder(
                        595,
                        842,
                        1
                    ).create()

                val page =
                    pdfDocument.startPage(pageInfo)

                val canvas =
                    page.canvas

                val paint =
                    Paint()

                // HEADER

                paint.textSize = 28f
                paint.isFakeBoldText = true

                canvas.drawText(
                    "PHARMATIC APOTEK",
                    140f,
                    60f,
                    paint
                )

                paint.textSize = 20f

                canvas.drawText(
                    "LAPORAN PENJUALAN",
                    150f,
                    95f,
                    paint
                )

                canvas.drawLine(
                    40f,
                    120f,
                    555f,
                    120f,
                    paint
                )

                paint.isFakeBoldText = false
                paint.textSize = 16f

                canvas.drawText(
                    "Tanggal Cetak : 02 Juni 2026",
                    50f,
                    155f,
                    paint
                )

                // TABEL

                val kiri = 50f
                val kanan = 545f
                val atas = 200f

                canvas.drawRect(
                    kiri,
                    atas,
                    kanan,
                    atas + 50f,
                    paint
                )

                canvas.drawText(
                    "KETERANGAN",
                    70f,
                    atas + 30f,
                    paint
                )

                canvas.drawText(
                    "NILAI",
                    390f,
                    atas + 30f,
                    paint
                )

                canvas.drawLine(
                    350f,
                    atas,
                    350f,
                    atas + 250f,
                    paint
                )

                canvas.drawText(
                    "Total Penjualan",
                    70f,
                    280f,
                    paint
                )

                canvas.drawText(
                    "Rp 103.000",
                    390f,
                    280f,
                    paint
                )

                canvas.drawLine(
                    kiri,
                    300f,
                    kanan,
                    300f,
                    paint
                )

                canvas.drawText(
                    "Jumlah Transaksi",
                    70f,
                    340f,
                    paint
                )

                canvas.drawText(
                    "15",
                    390f,
                    340f,
                    paint
                )

                canvas.drawLine(
                    kiri,
                    360f,
                    kanan,
                    360f,
                    paint
                )

                canvas.drawText(
                    "Jumlah Obat Terjual",
                    70f,
                    400f,
                    paint
                )

                canvas.drawText(
                    "42",
                    390f,
                    400f,
                    paint
                )

                canvas.drawLine(
                    kiri,
                    420f,
                    kanan,
                    420f,
                    paint
                )

                canvas.drawText(
                    "Obat Terlaris",
                    70f,
                    460f,
                    paint
                )

                canvas.drawText(
                    "Paracetamol",
                    390f,
                    460f,
                    paint
                )

                canvas.drawLine(
                    kiri,
                    480f,
                    kanan,
                    480f,
                    paint
                )

                canvas.drawLine(
                    kiri,
                    atas,
                    kiri,
                    480f,
                    paint
                )

                canvas.drawLine(
                    kanan,
                    atas,
                    kanan,
                    480f,
                    paint
                )

                // TANDA TANGAN

                canvas.drawText(
                    "Admin PharmaTic",
                    380f,
                    650f,
                    paint
                )

                canvas.drawText(
                    "________________",
                    350f,
                    720f,
                    paint
                )

                pdfDocument.finishPage(page)

                val file =
                    File(
                        getExternalFilesDir(null),
                        "Laporan_Penjualan.pdf"
                    )

                pdfDocument.writeTo(
                    FileOutputStream(file)
                )

                pdfDocument.close()

                val uri: Uri =
                    FileProvider.getUriForFile(
                        this,
                        "${packageName}.provider",
                        file
                    )

                val intent =
                    Intent(Intent.ACTION_VIEW)

                intent.setDataAndType(
                    uri,
                    "application/pdf"
                )

                intent.addFlags(
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )

                startActivity(intent)

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    "Gagal membuka PDF",
                    Toast.LENGTH_LONG
                ).show()

                e.printStackTrace()
            }
        }
    }
}