package com.example.tugassbesarr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TambahObatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_obat)

        val etNama = findViewById<EditText>(R.id.etNamaObatBaru)
        val etJenis = findViewById<EditText>(R.id.etJenisObatBaru)
        val etStok = findViewById<EditText>(R.id.etStokObatBaru)
        val etHarga = findViewById<EditText>(R.id.etHargaObatBaru)
        val btnSimpan = findViewById<Button>(R.id.btnSimpanObat)

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val jenis = etJenis.text.toString()
            val stok = etStok.text.toString()
            val harga = etHarga.text.toString()

            if (nama.isNotEmpty() && jenis.isNotEmpty() && stok.isNotEmpty() && harga.isNotEmpty()) {
                // Di sini nantinya kita bisa tambahkan kode untuk menyimpan ke Database
                Toast.makeText(this, "Obat $nama berhasil disimpan!", Toast.LENGTH_SHORT).show()
                finish() // Kembali ke dashboard admin setelah simpan
            } else {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
