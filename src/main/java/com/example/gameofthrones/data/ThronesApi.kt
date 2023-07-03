package com.example.gameofthrones.data

import com.example.gameofthrones.data.model.AllCharacters
import retrofit2.http.GET
import retrofit2.http.Headers

interface ThronesApi {

    @Headers("Content-Type: application/json")
    @GET("api/v2/characters")
    suspend fun getAllCharacters(): AllCharacters

}