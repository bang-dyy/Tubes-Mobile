package com.example.pharmatic.pembayaran

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmatic.R
import com.example.pharmatic.keranjang.KeranjangManager
import com.example.pharmatic.struk.StrukActivity

class PembayaranActivity : AppCompatActivity() {

    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        val tvTotal =
            findViewById<TextView>(R.id.tvTotalBayar)

        val tvKembalian =
            findViewById<TextView>(R.id.tvKembalian)

        val etNominal =
            findViewById<EditText>(R.id.etNominal)

        val btnHitung =
            findViewById<Button>(R.id.btnHitung)

        val btnBayar =
            findViewById<Button>(R.id.btnBayar)

        for (obat in KeranjangManager.daftarKeranjang) {
            total += obat.harga
        }

        tvTotal.text = "Rp $total"

        btnHitung.setOnClickListener {

            val bayar =
                etNominal.text.toString()

            if (bayar.isEmpty()) {

                Toast.makeText(
                    this,
                    "Masukkan nominal pembayaran",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val nominal = bayar.toInt()

            if (nominal < total) {

                Toast.makeText(
                    this,
                    "Uang tidak cukup",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val kembalian =
                nominal - total

            tvKembalian.text =
                "Rp $kembalian"
        }

        btnBayar.setOnClickListener {

            val bayar =
                etNominal.text.toString()

            if (bayar.isEmpty()) {

                Toast.makeText(
                    this,
                    "Masukkan nominal pembayaran terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val nominal = bayar.toInt()

            if (nominal < total) {

                Toast.makeText(
                    this,
                    "Pembayaran belum mencukupi",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val kembalian = nominal - total

            val intent =
                Intent(
                    this,
                    StrukActivity::class.java
                )

            intent.putExtra("TOTAL", total)
            intent.putExtra("BAYAR", nominal)
            intent.putExtra("KEMBALIAN", kembalian)

            startActivity(intent)
        }
    }
}