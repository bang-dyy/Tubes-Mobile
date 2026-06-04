package com.example.tugassbesarr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuplierAdapter(private val listSuplier: List<Suplier>) : RecyclerView.Adapter<SuplierAdapter.SuplierViewHolder>() {

    class SuplierViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNamaSuplier)
        val tvAlamat: TextView = view.findViewById(R.id.tvAlamatSuplier)
        val tvTelp: TextView = view.findViewById(R.id.tvTelpSuplier)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuplierViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_suplier, parent, false)
        return SuplierViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuplierViewHolder, position: Int) {
        val suplier = listSuplier[position]
        holder.tvNama.text = suplier.nama
        holder.tvAlamat.text = suplier.alamat
        holder.tvTelp.text = suplier.telepon
    }

    override fun getItemCount(): Int = listSuplier.size
}