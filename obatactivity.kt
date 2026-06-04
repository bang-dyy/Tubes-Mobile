package com.example.pharmaticadmin.obat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaticadmin.R

class ObatActivity : AppCompatActivity() {

    private lateinit var rvObat: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obat_admin)

        rvObat = findViewById(R.id.rvObat)

        val btnTambah =
            findViewById<Button>(R.id.btnTambah)

        rvObat.layoutManager =
            LinearLayoutManager(this)

        rvObat.adapter =
            ObatAdapter(
                ObatManager.daftarObat
            )

        btnTambah.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    TambahObatActivity::class.java
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()

        rvObat.adapter =
            ObatAdapter(
                ObatManager.daftarObat
            )
    }
}