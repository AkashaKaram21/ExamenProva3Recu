package com.example.examenrecu.recyclerViewDetallEstacio

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu.R
import org.w3c.dom.Text

//EstacioViewHolder
class EstacioViewHolder(
    itemView: View,
    private val onItemClick: (Estacio) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val tvNom: TextView = itemView.findViewById(R.id.tvNom)
    private val tvUbicacio: TextView = itemView.findViewById(R.id.tvUbicacio)

    // Dins del teu MyViewHolder.kt
    fun bind(item: Estacio) {
        tvNom.text = item.nom
        tvUbicacio.text = item.ubicacio

        itemView.setOnClickListener { onItemClick(item) }
    }
}