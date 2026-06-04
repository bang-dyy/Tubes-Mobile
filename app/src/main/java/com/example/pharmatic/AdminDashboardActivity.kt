package com.example.tugassbesarr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class AdminDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        val cardObat = findViewById<CardView>(R.id.cardKelolaObat)
        val cardKasir = findViewById<CardView>(R.id.cardKelolaKasir)
        val btnLogout = findViewById<Button>(R.id.btnAdminLogout)
        val cardSuplier = findViewById<CardView>(R.id.cardKelolaSuplier)
        val cardLaporan = findViewById<CardView>(R.id.cardLaporan)


        cardObat.setOnClickListener {
            val intent = Intent(this, TambahObatActivity::class.java)
            startActivity(intent)
        }

        cardKasir.setOnClickListener {
            val intent = Intent(this, KelolaKasirActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


        cardSuplier.setOnClickListener {
            val intent = Intent(this, KelolaSuplierActivity::class.java)
            startActivity(intent)
        }

        cardLaporan.setOnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        }
    }
}