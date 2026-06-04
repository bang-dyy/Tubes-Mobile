package com.example.pharmaticadmin.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaticadmin.R

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val rvHistory =
            findViewById<RecyclerView>(R.id.rvHistory)

        val dataHistory = listOf(
            History("01/06/2026","Andi",35000),
            History("02/06/2026","Budi",47000),
            History("03/06/2026","Siti",21000)
        )

        rvHistory.layoutManager =
            LinearLayoutManager(this)

        rvHistory.adapter =
            HistoryAdapter(dataHistory)
    }
}