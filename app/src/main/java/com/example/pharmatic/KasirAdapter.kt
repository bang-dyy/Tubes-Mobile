package com.example.tugassbesarr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KasirAdapter(private val listKasir: List<Kasir>) : RecyclerView.Adapter<KasirAdapter.KasirViewHolder>() {

    class KasirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNamaKasir)
        val tvUsername: TextView = view.findViewById(R.id.tvUsernameKasir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KasirViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kasir, parent, false)
        return KasirViewHolder(view)
    }

    override fun onBindViewHolder(holder: KasirViewHolder, position: Int) {
        val kasir = listKasir[position]
        holder.tvNama.text = kasir.nama
        holder.tvUsername.text = "@${kasir.username}"
    }

    override fun getItemCount(): Int = listKasir.size
}