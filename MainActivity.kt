package com.example.pharmaticadmin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.pharmaticadmin.history.HistoryActivity
import com.example.pharmaticadmin.kasir.KasirActivity
import com.example.pharmaticadmin.laporan.LaporanActivity
import com.example.pharmaticadmin.obat.ObatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CardView>(R.id.cardObat)
            .setOnClickListener {
                startActivity(
                    Intent(this, ObatActivity::class.java)
                )
            }

        findViewById<CardView>(R.id.cardKasir)
            .setOnClickListener {
                startActivity(
                    Intent(this, KasirActivity::class.java)
                )
            }

        findViewById<CardView>(R.id.cardHistory)
            .setOnClickListener {
                startActivity(
                    Intent(this, HistoryActivity::class.java)
                )
            }

        findViewById<CardView>(R.id.cardLaporan)
            .setOnClickListener {
                startActivity(
                    Intent(this, LaporanActivity::class.java)
                )
            }
    }
}