package com.example.pharmaticadmin.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaticadmin.R

class HistoryAdapter(
    private val listHistory: List<History>
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvTanggal: TextView =
            itemView.findViewById(R.id.tvTanggal)

        val tvKasir: TextView =
            itemView.findViewById(R.id.tvKasir)

        val tvTotal: TextView =
            itemView.findViewById(R.id.tvTotal)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_history,
                    parent,
                    false
                )

        return ViewHolder(view)
    }

    override fun getItemCount() =
        listHistory.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val history =
            listHistory[position]

        holder.tvTanggal.text =
            history.tanggal

        holder.tvKasir.text =
            "Kasir : ${history.kasir}"

        holder.tvTotal.text =
            "Total : Rp ${history.total}"
    }
}