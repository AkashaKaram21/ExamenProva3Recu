package com.example.examenrecu.recyclerViewEstacio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu.R

//RegistreAdapter
class RegistreAdapter(
    private var items: List<Registre>,
    private val onItemClick: (Registre) -> Unit
) : RecyclerView.Adapter<RegistreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistreHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_registre, parent, false)
        return RegistreHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: RegistreHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateList(newList: List<Registre>) {
        items = newList
        notifyDataSetChanged()
    }
}