package com.example.pharmaticadmin.obat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaticadmin.R

class TambahObatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_obat)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etHarga = findViewById<EditText>(R.id.etHarga)
        val etStok = findViewById<EditText>(R.id.etStok)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {

            if (
                etNama.text.toString().isEmpty() ||
                etHarga.text.toString().isEmpty() ||
                etStok.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Lengkapi data terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            ObatManager.daftarObat.add(
                Obat(
                    etNama.text.toString(),
                    etHarga.text.toString().toInt(),
                    etStok.text.toString().toInt()
                )
            )

            Toast.makeText(
                this,
                "Obat berhasil ditambahkan",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}