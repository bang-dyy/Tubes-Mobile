package com.example.pharmatic.obat

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmatic.R
import com.example.pharmatic.keranjang.KeranjangActivity
import com.example.pharmatic.keranjang.KeranjangManager

class ObatActivity : AppCompatActivity() {

    private lateinit var rvObat: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obat)

        rvObat = findViewById(R.id.rvObat)

        val dataObat = listOf(
            Obat("Paracetamol 500mg", 5000, 50),
            Obat("Sanmol", 6000, 45),
            Obat("Panadol", 7000, 40),
            Obat("Bodrex", 4000, 60),
            Obat("Bodrex Extra", 5000, 35),
            Obat("Mixagrip", 5000, 40),
            Obat("Decolgen", 6000, 30),
            Obat("Procold", 6500, 25),
            Obat("Konidin", 10000, 20),
            Obat("OBH Combi", 15000, 25),

            Obat("Antangin", 3500, 70),
            Obat("Tolak Angin", 4000, 80),
            Obat("Promag", 8000, 35),
            Obat("Mylanta", 14000, 18),
            Obat("Polysilane", 12000, 20),
            Obat("Diapet", 12000, 15),
            Obat("Entrostop", 9000, 25),
            Obat("Oralit", 3000, 50),

            Obat("Vitamin C IPI", 7000, 40),
            Obat("Redoxon", 25000, 20),
            Obat("Enervon-C", 18000, 25),
            Obat("Sangobion", 17000, 22),
            Obat("Neurobion", 22000, 15),
            Obat("Imboost", 30000, 12),

            Obat("Betadine", 18000, 20),
            Obat("Hansaplast", 10000, 30),
            Obat("Rivanol", 12000, 15),
            Obat("Bioplacenton", 28000, 12),

            Obat("Insto", 13000, 28),
            Obat("Rohto", 15000, 20),
            Obat("Cendo Xitrol", 25000, 10),

            Obat("Amoxicillin 500mg", 12000, 30),
            Obat("Cefixime 100mg", 25000, 15),
            Obat("Amlodipine 5mg", 18000, 20),
            Obat("Captopril 25mg", 15000, 18),
            Obat("Metformin 500mg", 20000, 22),

            Obat("Cetirizine", 10000, 30),
            Obat("Loratadine", 12000, 25),
            Obat("CTM", 5000, 40),

            Obat("Termorex Sirup", 18000, 20),
            Obat("Sanmol Sirup", 17000, 25),
            Obat("OBH Combi Anak", 16000, 18)
        )

        rvObat.layoutManager = LinearLayoutManager(this)

        val adapter = ObatAdapter(dataObat)
        rvObat.adapter = adapter

        val etCari = findViewById<EditText>(R.id.etCari)

        etCari.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                val keyword = s.toString().lowercase()

                val hasilFilter = dataObat.filter {
                    it.nama.lowercase().contains(keyword)
                }

                adapter.updateData(hasilFilter)
            }

            override fun afterTextChanged(
                s: Editable?
            ) {}
        })

        val btnKeranjang =
            findViewById<Button>(R.id.btnKeranjang)

        btnKeranjang.setOnClickListener {

            if (KeranjangManager.daftarKeranjang.isEmpty()) {

                Toast.makeText(
                    this,
                    "⚠️ Silakan pilih obat terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            startActivity(
                Intent(
                    this,
                    KeranjangActivity::class.java
                )
            )
        }
    }
}