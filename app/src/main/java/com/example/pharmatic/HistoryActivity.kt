package com.example.tugassbesarr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val rvHistory = findViewById<RecyclerView>(R.id.rvHistory)
        rvHistory.layoutManager = LinearLayoutManager(this)

        // Data Riwayat Contoh
        val dataHistory = listOf(
            Transaksi("#TRX-001", "10 Feb 2025, 10:30", 2, "Rp 15.000"),
            Transaksi("#TRX-002", "10 Feb 2025, 11:15", 1, "Rp 25.000"),
            Transaksi("#TRX-003", "11 Feb 2025, 09:00", 4, "Rp 42.500"),
            Transaksi("#TRX-004", "11 Feb 2025, 14:45", 2, "Rp 10.000"),
            Transaksi("#TRX-005", "12 Feb 2025, 08:20", 3, "Rp 35.000")
        )

        val adapter = HistoryAdapter(dataHistory)
        rvHistory.adapter = adapter
    }
}