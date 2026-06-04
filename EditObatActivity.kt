package com.example.pharmaticadmin.obat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaticadmin.R

class EditObatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_obat)

        val etNama =
            findViewById<EditText>(R.id.etNama)

        val etHarga =
            findViewById<EditText>(R.id.etHarga)

        val etStok =
            findViewById<EditText>(R.id.etStok)

        val btnUpdate =
            findViewById<Button>(R.id.btnUpdate)

        val posisi =
            intent.getIntExtra("posisi", -1)

        if (posisi != -1) {

            val obat =
                ObatManager.daftarObat[posisi]

            etNama.setText(obat.nama)
            etHarga.setText(obat.harga.toString())
            etStok.setText(obat.stok.toString())
        }

        btnUpdate.setOnClickListener {

            if (
                etNama.text.isEmpty() ||
                etHarga.text.isEmpty() ||
                etStok.text.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Lengkapi data terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            ObatManager.daftarObat[posisi] =
                Obat(
                    etNama.text.toString(),
                    etHarga.text.toString().toInt(),
                    etStok.text.toString().toInt()
                )

            Toast.makeText(
                this,
                "Data obat berhasil diupdate",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}