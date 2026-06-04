package com.example.tugassbesarr

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class KelolaKasirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_kasir)

        val rvKasir = findViewById<RecyclerView>(R.id.rvKasir)
        val fabTambah = findViewById<FloatingActionButton>(R.id.fabTambahKasir)

        rvKasir.layoutManager = LinearLayoutManager(this)

        // Data dummy daftar kasir
        val dataKasir = listOf(
            Kasir("Ardy", "kasir1"),
            Kasir("Budi", "budi_kasir"),
            Kasir("Siti Aminah", "siti22")
        )

        val adapter = KasirAdapter(dataKasir)
        rvKasir.adapter = adapter

        fabTambah.setOnClickListener {
            val intent = Intent(this, TambahKasirActivity::class.java)
            startActivity(intent)
        }
    }
}