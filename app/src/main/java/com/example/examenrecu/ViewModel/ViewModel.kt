package com.example.examenrecu.ViewModel

import android.util.Log
import androidx.constraintlayout.widget.ReactiveGuide
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenrecu.Retrofit.ItemAPI
import com.example.examenrecu.recyclerViewDetallEstacio.Estacio
import com.example.examenrecu.recyclerViewEstacio.Registre
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel : ViewModel() {

    private val _estacio = MutableLiveData<List<Estacio>>()
    val estacio: LiveData<List<Estacio>> get() = _estacio

    private val _registre = MutableLiveData<List<Registre>>(emptyList())
    val registre: LiveData<List<Registre>> = _registre


    // Obtener todos los materiales
    fun fetchEstacio() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ItemAPI.API().getEstacio()
                if (response.isSuccessful) {
                    _estacio.postValue(response.body())
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error cargando: ${e.message}")
            }
        }
    }

    fun cargarRegistre(idEstacio: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ItemAPI.API().obtenerRegistre(idEstacio)

                if (response.isSuccessful) {
                    val lista = response.body() ?: emptyList()

                    withContext(Dispatchers.Main) {
                        _registre.value = lista
                    }
                } else {
                    Log.e("API", "Error Reserves: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("API", "Error de connexió Reserves", e)
            }
        }
    }

    // POST Estacio
    fun guardarEstacio(estacio: Estacio) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response =  ItemAPI.API().crearEstacio(estacio)

                if (response.isSuccessful) {
                    fetchEstacio()
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error guardando: ${e.message}")
            }
        }
    }

}