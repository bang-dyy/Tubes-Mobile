package com.example.tugassbesarr

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LaporanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        val rvLaporan = findViewById<RecyclerView>(R.id.rvLaporanRiwayat)
        val tvPendapatan = findViewById<TextView>(R.id.tvTotalPendapatan)
        val tvTransaksi = findViewById<TextView>(R.id.tvTotalTransaksi)

        rvLaporan.layoutManager = LinearLayoutManager(this)

        // Data Ringkasan (Contoh)
        tvPendapatan.text = "Rp 2.450.000"
        tvTransaksi.text = "12 Transaksi"

        // Data Riwayat untuk Admin
        val dataRiwayat = listOf(
            Transaksi("#TRX-005", "12 Feb 2025", 3, "Rp 150.000"),
            Transaksi("#TRX-004", "12 Feb 2025", 1, "Rp 25.000"),
            Transaksi("#TRX-003", "11 Feb 2025", 5, "Rp 500.000"),
            Transaksi("#TRX-002", "11 Feb 2025", 2, "Rp 75.000"),
            Transaksi("#TRX-001", "10 Feb 2025", 4, "Rp 120.000")
        )

        val adapter = HistoryAdapter(dataRiwayat)
        rvLaporan.adapter = adapter
    }
}