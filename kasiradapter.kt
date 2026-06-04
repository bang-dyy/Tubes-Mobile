package com.example.pharmaticadmin.kasir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaticadmin.R

class KasirAdapter(
    private val listKasir: MutableList<Kasir>
) : RecyclerView.Adapter<KasirAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvNamaKasir: TextView =
            itemView.findViewById(R.id.tvNamaKasir)

        val tvUsername: TextView =
            itemView.findViewById(R.id.tvUsername)

        val btnEditKasir: Button =
            itemView.findViewById(R.id.btnEditKasir)

        val btnHapusKasir: Button =
            itemView.findViewById(R.id.btnHapusKasir)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_kasir,
                    parent,
                    false
                )

        return ViewHolder(view)
    }

    override fun getItemCount(): Int =
        listKasir.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val kasir = listKasir[position]

        holder.tvNamaKasir.text =
            kasir.nama

        holder.tvUsername.text =
            "Username : ${kasir.username}"

        holder.btnEditKasir.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                EditKasirActivity::class.java
            )

            intent.putExtra(
                "posisi",
                position
            )

            holder.itemView.context
                .startActivity(intent)
        }

        holder.btnHapusKasir.setOnClickListener {

            val namaKasir = kasir.nama

            listKasir.removeAt(position)

            notifyItemRemoved(position)

            notifyItemRangeChanged(
                position,
                listKasir.size
            )

            Toast.makeText(
                holder.itemView.context,
                "$namaKasir berhasil dihapus",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}