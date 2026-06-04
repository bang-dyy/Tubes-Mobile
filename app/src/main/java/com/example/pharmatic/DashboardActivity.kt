package com.example.tugassbesarr

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Inisialisasi CardView dari layout
        val cardTransaksi = findViewById<CardView>(R.id.cardTransaksi)
        val cardObat = findViewById<CardView>(R.id.cardObat)
        val cardHistory = findViewById<CardView>(R.id.cardHistory)
        val cardLogout = findViewById<CardView>(R.id.cardLogout)

        // Event Klik Transaksi
        cardTransaksi.setOnClickListener {
            val intent = Intent(this, TransaksiActivity::class.java)
            startActivity(intent)
        }

        // Event Klik Stok Obat
        cardObat.setOnClickListener {
            val intent = Intent(this, ObatActivity::class.java)
            startActivity(intent)
        }

        // Event Klik Riwayat
        cardHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        // Event Klik Logout (Kembali ke Login)
        cardLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Menutup Dashboard agar tidak bisa kembali dengan tombol back
            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
        }
    }
}