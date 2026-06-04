package com.example.pharmaticadmin.kasir

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaticadmin.R

class TambahKasirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kasir)

        val etNama =
            findViewById<EditText>(R.id.etNamaKasir)

        val etUsername =
            findViewById<EditText>(R.id.etUsernameKasir)

        val btnSimpan =
            findViewById<Button>(R.id.btnSimpanKasir)

        btnSimpan.setOnClickListener {

            if (
                etNama.text.isEmpty() ||
                etUsername.text.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Lengkapi data terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            KasirManager.daftarKasir.add(

                Kasir(
                    etNama.text.toString(),
                    etUsername.text.toString()
                )
            )

            Toast.makeText(
                this,
                "Kasir berhasil ditambahkan",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}