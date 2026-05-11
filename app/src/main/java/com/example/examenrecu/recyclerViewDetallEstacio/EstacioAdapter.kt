package com.example.proba.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu.R
import com.example.examenrecu.recyclerViewDetallEstacio.Estacio
import com.example.examenrecu.recyclerViewDetallEstacio.EstacioViewHolder

class EstacioAdapter(
    private var items: List<Estacio>,
    private val onItemClick: (Estacio) -> Unit
) : RecyclerView.Adapter<EstacioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstacioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_estacio, parent, false)
        return EstacioViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: EstacioViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateList(newList: List<Estacio>) {
        items = newList
        notifyDataSetChanged()
    }
}