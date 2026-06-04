package com.example.tugassbesarr

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TransaksiActivity : AppCompatActivity() {

    private var totalHarga = 0
    private var totalItem = 0
    private lateinit var tvTotalHarga: TextView
    private lateinit var tvTotalItem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        tvTotalHarga = findViewById(R.id.tvTotalHarga)
        tvTotalItem = findViewById(R.id.tvTotalItem)
        val btnBayar = findViewById<Button>(R.id.btnBayar)
        val rvPilihObat = findViewById<RecyclerView>(R.id.rvPilihObat)

        // Setup RecyclerView
        rvPilihObat.layoutManager = LinearLayoutManager(this)

        // Data obat yang bisa dipilih (bisa disamakan dengan data di Stok Obat)
        val dataObat = listOf(
            Obat("Paracetamol", "Tablet", 50, 5000, "Rp 5.000"),
            Obat("Amoxicillin", "Kapsul", 30, 12000, "Rp 12.000"),
            Obat("Obat Batuk Cair", "Sirup", 15, 25000, "Rp 25.000"),
            Obat("Promag", "Tablet", 40, 8500, "Rp 8.500")
        )

        val adapter = TransaksiAdapter(dataObat) { obat ->
            tambahKeKeranjang(obat)
        }
        rvPilihObat.adapter = adapter

        btnBayar.setOnClickListener {
            if (totalItem > 0) {
                Toast.makeText(this, "Pembayaran sebesar Rp $totalHarga berhasil!", Toast.LENGTH_LONG).show()
                // Reset keranjang setelah bayar
                totalHarga = 0
                totalItem = 0
                updateUI()
            } else {
                Toast.makeText(this, "Keranjang masih kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun tambahKeKeranjang(obat: Obat) {
        totalItem += 1
        totalHarga += obat.harga
        updateUI()
    }

    private fun updateUI() {
        tvTotalItem.text = totalItem.toString()
        tvTotalHarga.text = "Rp $totalHarga"
    }
}