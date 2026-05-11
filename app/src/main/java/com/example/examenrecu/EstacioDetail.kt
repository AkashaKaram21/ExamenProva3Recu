package com.example.examenrecu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu.ViewModel.ViewModel
import com.example.examenrecu.recyclerViewEstacio.RegistreAdapter

class EstacioDetail : AppCompatActivity() {

    private val viewModel: ViewModel by viewModels()
    private lateinit var adapter: RegistreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estacio_detail)

        // 1. Buscamos el RecyclerView
        val rvRegistre = findViewById<RecyclerView>(R.id.recyclerViewRegistres)
        // val btnCreate = findViewById<Button>(R.id.btnCreate)

        // 2. Configuramos el Adapter
        adapter = RegistreAdapter(
            emptyList(),
            onItemClick = {
            }
        )

        // 3. Configuramos el RecyclerView
        rvRegistre.layoutManager = LinearLayoutManager(this)
        rvRegistre.adapter = adapter

        // 4. Observar la lista de materiales
        viewModel.registre.observe(this) { lista ->
            adapter.updateList(lista)
        }


        val idUsuari = intent.getIntExtra("USUARI_ID", -1)

        // El ViewModel de esta pantalla se encarga de buscar las reservas
        if (idUsuari != -1) {
            viewModel.cargarRegistre(idUsuari)
        }
    }
}