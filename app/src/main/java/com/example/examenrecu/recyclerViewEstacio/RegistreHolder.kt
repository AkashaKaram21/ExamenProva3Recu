package com.example.examenrecu.recyclerViewEstacio

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu.R

//RegistreHolder
class RegistreHolder(
    itemView: View,
    private val onItemClick: (Registre) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val tvHora: TextView = itemView.findViewById(R.id.tvHora)
    //Double
    private val tvTemperatura: TextView = itemView.findViewById(R.id.tvTemperatura)
    private val tvHumitat: TextView = itemView.findViewById(R.id.tvHumitat)
    private val tvCo2: TextView = itemView.findViewById(R.id.tvCo2)

    // Dins del teu MyViewHolder.kt
    fun bind(item: Registre) {
        tvHora.text = item.hora
        itemView.setOnClickListener { onItemClick(item) }
    }
}