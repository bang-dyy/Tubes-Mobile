package com.example.pharmatic.struk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmatic.MainActivity
import com.example.pharmatic.R
import com.example.pharmatic.keranjang.KeranjangManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StrukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_struk)

        val tvStruk =
            findViewById<TextView>(R.id.tvStruk)

        val btnSelesai =
            findViewById<Button>(R.id.btnSelesai)

        val total =
            intent.getIntExtra("TOTAL", 0)

        val bayar =
            intent.getIntExtra("BAYAR", 0)

        val kembalian =
            intent.getIntExtra("KEMBALIAN", 0)

        val grouped =
            KeranjangManager.daftarKeranjang.groupBy { it.nama }

        val tanggal = SimpleDateFormat(
            "dd-MM-yyyy",
            Locale("id", "ID")
        ).format(Date())

        val jam = SimpleDateFormat(
            "HH:mm",
            Locale("id", "ID")
        ).format(Date())

        var isiStruk = ""

        isiStruk += "🏥 PHARMATIC APOTEK\n"
        isiStruk += "================================\n\n"

        isiStruk += String.format(
            "%-18s %-5s %-10s\n",
            "Nama Obat",
            "Qty",
            "Total"
        )

        isiStruk += "--------------------------------\n"

        for ((nama, daftar) in grouped) {

            val qty = daftar.size
            val subtotal = qty * daftar[0].harga

            isiStruk += String.format(
                "%-18s %-5d %-10d\n",
                nama.take(18),
                qty,
                subtotal
            )
        }

        isiStruk += "\n--------------------------------\n\n"

        isiStruk += String.format(
            "%-12s : Rp %,d\n",
            "TOTAL",
            total
        )

        isiStruk += String.format(
            "%-12s : Rp %,d\n",
            "BAYAR",
            bayar
        )

        isiStruk += String.format(
            "%-12s : Rp %,d\n",
            "KEMBALI",
            kembalian
        )

        isiStruk += "\n--------------------------------\n"
        isiStruk += "Tanggal : $tanggal\n"
        isiStruk += "Jam     : $jam\n"

        isiStruk += "\n================================\n\n"
        isiStruk += "✓ Transaksi Berhasil\n\n"
        isiStruk += "Terima Kasih !\n"
        isiStruk += "Semoga Lekas Sembuh !"

        tvStruk.text = isiStruk

        btnSelesai.setOnClickListener {

            KeranjangManager.daftarKeranjang.clear()

            val intent =
                Intent(
                    this,
                    MainActivity::class.java
                )

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)

            finish()
        }
    }
}