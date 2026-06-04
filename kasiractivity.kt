package com.example.pharmaticadmin.kasir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaticadmin.R

class KasirActivity : AppCompatActivity() {

    private lateinit var rvKasir: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir)

        rvKasir =
            findViewById(R.id.rvKasir)

        val btnTambahKasir =
            findViewById<Button>(R.id.btnTambahKasir)

        rvKasir.layoutManager =
            LinearLayoutManager(this)

        rvKasir.adapter =
            KasirAdapter(
                KasirManager.daftarKasir
            )

        btnTambahKasir.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    TambahKasirActivity::class.java
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()

        rvKasir.adapter =
            KasirAdapter(
                KasirManager.daftarKasir
            )
    }
}