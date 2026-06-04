package com.example.tugassbesarr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahKasirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kasir)

        val etNama = findViewById<EditText>(R.id.etNamaKasirBaru)
        val etUsername = findViewById<EditText>(R.id.etUsernameKasirBaru)
        val etPassword = findViewById<EditText>(R.id.etPasswordKasirBaru)
        val btnSimpan = findViewById<Button>(R.id.btnSimpanKasir)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val user = etUsername.text.toString()
            val pass = etPassword.text.toString()

            if (nama.isNotEmpty() && user.isNotEmpty() && pass.isNotEmpty()) {
                Toast.makeText(this, "Akun kasir $nama berhasil dibuat!", Toast.LENGTH_SHORT).show()
                finish() // Menutup halaman dan kembali ke daftar kasir
            } else {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}