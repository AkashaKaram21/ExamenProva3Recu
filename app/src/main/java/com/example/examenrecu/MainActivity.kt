package com.example.examenrecu

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu.ViewModel.ViewModel
import com.example.proba.RecyclerView.EstacioAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by viewModels()
    private lateinit var adapter: EstacioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        // 1. Buscamos el RecyclerView
        val rvEstacio = findViewById<RecyclerView>(R.id.recyclerView)
        // val btnCreate = findViewById<Button>(R.id.btnCreate)

        // 2. Configuramos el Adapter
        adapter = EstacioAdapter(
            emptyList(),
            onItemClick = { estacio ->
                val intent = Intent(this, EstacioDetail::class.java)
                intent.putExtra("estacio_id", estacio.id)
                startActivity(intent)
            }
        )

        // 3. Configuramos el RecyclerView
        rvEstacio.layoutManager = LinearLayoutManager(this)
        rvEstacio.adapter = adapter

        // 4. Observar la lista de materiales
        viewModel.estacio.observe(this) { lista ->
            adapter.updateList(lista)
        }

        // 6. Cargar los datos
        viewModel.fetchEstacio()

    }
}