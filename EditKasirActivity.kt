package com.example.pharmaticadmin.kasir

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaticadmin.R

class EditKasirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_kasir)

        val etNama =
            findViewById<EditText>(R.id.etNamaKasir)

        val etUsername =
            findViewById<EditText>(R.id.etUsernameKasir)

        val btnUpdate =
            findViewById<Button>(R.id.btnUpdateKasir)

        val posisi =
            intent.getIntExtra("posisi", -1)

        if (posisi != -1) {

            val kasir =
                KasirManager.daftarKasir[posisi]

            etNama.setText(kasir.nama)
            etUsername.setText(kasir.username)
        }

        btnUpdate.setOnClickListener {

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

            KasirManager.daftarKasir[posisi] =
                Kasir(
                    etNama.text.toString(),
                    etUsername.text.toString()
                )

            Toast.makeText(
                this,
                "Data kasir berhasil diupdate",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}