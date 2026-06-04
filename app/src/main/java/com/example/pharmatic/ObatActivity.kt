package com.example.tugassbesarr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ObatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obat)

        val rvObat = findViewById<RecyclerView>(R.id.rvObat)
        rvObat.layoutManager = LinearLayoutManager(this)


        val dataObat = listOf(
            Obat("Paracetamol", "Tablet", 50, 5000, "Rp 5.000"),
            Obat("Amoxicillin", "Kapsul", 30, 12000, "Rp 12.000"),
            Obat("Obat Batuk Cair", "Sirup", 15, 25000, "Rp 25.000"),
            Obat("Promag", "Tablet", 40, 8500, "Rp 8.500"),
            Obat("Vitamin C", "Tablet", 100, 2000, "Rp 2.000"),
            Obat("Betadine", "Cair", 20, 15000, "Rp 15.000")
        )

        val adapter = ObatAdapter(dataObat)
        rvObat.adapter = adapter
    }
}
