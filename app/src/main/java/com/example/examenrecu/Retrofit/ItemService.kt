package com.example.examenrecu.Retrofit

import com.example.examenrecu.recyclerViewDetallEstacio.Estacio
import com.example.examenrecu.recyclerViewEstacio.Registre
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ItemService {

    @POST("/estacions/detall")
    suspend fun crearEstacio(@Body estacioRequest : Estacio) : Response<Estacio>

    @GET("estacions/")
    suspend fun getEstacio(): Response<List<Estacio>>

    @GET("/estacions/{id}/registres/avui")
    suspend fun obtenerRegistre(@Path("id") id: Int): Response<List<Registre>>

}