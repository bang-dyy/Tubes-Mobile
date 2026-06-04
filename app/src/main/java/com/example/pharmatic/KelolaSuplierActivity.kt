package com.example.tugassbesarr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KelolaSuplierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_suplier)

        val rvSuplier = findViewById<RecyclerView>(R.id.rvSuplier)
        rvSuplier.layoutManager = LinearLayoutManager(this)

        // Data dummy daftar suplier
        val dataSuplier = listOf(
            Suplier("PT. Farmasi Jaya", "Jl. Raya Merdeka No. 10", "08123456789"),
            Suplier("CV. Sehat Abadi", "Jl. Melati No. 5, Bandung", "08219988776"),
            Suplier("Sumber Obat Mandiri", "Kawasan Industri Cikarang", "021-889977")
        )

        val adapter = SuplierAdapter(dataSuplier)
        rvSuplier.adapter = adapter
    }
}