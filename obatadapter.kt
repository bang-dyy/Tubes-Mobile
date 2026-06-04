package com.example.pharmaticadmin.obat

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaticadmin.R

class ObatAdapter(
    private val listObat: MutableList<Obat>
) : RecyclerView.Adapter<ObatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvNama: TextView =
            itemView.findViewById(R.id.tvNama)

        val tvHarga: TextView =
            itemView.findViewById(R.id.tvHarga)

        val tvStok: TextView =
            itemView.findViewById(R.id.tvStok)

        val btnEdit: Button =
            itemView.findViewById(R.id.btnEdit)

        val btnHapus: Button =
            itemView.findViewById(R.id.btnHapus)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_obat_admin,
                    parent,
                    false
                )

        return ViewHolder(view)
    }

    override fun getItemCount(): Int =
        listObat.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val obat = listObat[position]

        holder.tvNama.text =
            obat.nama

        holder.tvHarga.text =
            "Harga : Rp ${obat.harga}"

        holder.tvStok.text =
            "Stok : ${obat.stok}"

        holder.btnEdit.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                EditObatActivity::class.java
            )

            intent.putExtra(
                "posisi",
                position
            )

            holder.itemView.context
                .startActivity(intent)
        }

        holder.btnHapus.setOnClickListener {

            val namaObat = obat.nama

            listObat.removeAt(position)

            notifyItemRemoved(position)

            notifyItemRangeChanged(
                position,
                listObat.size
            )

            Toast.makeText(
                holder.itemView.context,
                "$namaObat berhasil dihapus",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}