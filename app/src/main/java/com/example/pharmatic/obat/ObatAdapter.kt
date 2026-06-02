package com.example.pharmatic.obat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmatic.R
import com.example.pharmatic.keranjang.KeranjangManager

class ObatAdapter(
    private var listObat: List<Obat>
) : RecyclerView.Adapter<ObatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val nama: TextView =
            itemView.findViewById(R.id.tvNama)

        val harga: TextView =
            itemView.findViewById(R.id.tvHarga)

        val stok: TextView =
            itemView.findViewById(R.id.tvStok)

        val jumlah: TextView =
            itemView.findViewById(R.id.tvJumlah)

        val btnPlus: TextView =
            itemView.findViewById(R.id.btnPlus)

        val btnMinus: TextView =
            itemView.findViewById(R.id.btnMinus)

        val btnTambah: Button =
            itemView.findViewById(R.id.btnTambah)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_obat, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listObat.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val obat = listObat[position]

        holder.nama.text = obat.nama
        holder.harga.text = "Rp ${obat.harga}"
        holder.stok.text = "Stok : ${obat.stok}"

        var jumlah = 0

        holder.jumlah.text = jumlah.toString()

        holder.btnPlus.setOnClickListener {
            jumlah++
            holder.jumlah.text = jumlah.toString()
        }

        holder.btnMinus.setOnClickListener {

            if (jumlah > 0) {
                jumlah--
                holder.jumlah.text = jumlah.toString()
            }
        }

        holder.btnTambah.setOnClickListener {

            if (jumlah == 0) {

                Toast.makeText(
                    holder.itemView.context,
                    "⚠️ Pilih jumlah obat terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            repeat(jumlah) {
                KeranjangManager.daftarKeranjang.add(obat)
            }

            Toast.makeText(
                holder.itemView.context,
                "✅ $jumlah ${obat.nama} ditambahkan ke keranjang",
                Toast.LENGTH_SHORT
            ).show()

            jumlah = 0
            holder.jumlah.text = jumlah.toString()
        }
    }

    fun updateData(dataBaru: List<Obat>) {
        listObat = dataBaru
        notifyDataSetChanged()
    }
}