package com.example.tugassbesarr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ObatAdapter(private val listObat: List<Obat>) : RecyclerView.Adapter<ObatAdapter.ObatViewHolder>() {

    class ObatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tvNamaObat)
        val tvJenis: TextView = view.findViewById(R.id.tvJenisObat)
        val tvHarga: TextView = view.findViewById(R.id.tvHargaObat)
        val tvStok: TextView = view.findViewById(R.id.tvStokObat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_obat, parent, false)
        return ObatViewHolder(view)
    }


    override fun onBindViewHolder(holder: ObatViewHolder, position: Int) {
        val obat = listObat[position]
        holder.tvNama.text = obat.nama
        holder.tvJenis.text = obat.jenis
        holder.tvHarga.text = obat.hargaDisplay
        holder.tvStok.text = "Stok: ${obat.stok}"
    }

    override fun getItemCount(): Int = listObat.size
}
