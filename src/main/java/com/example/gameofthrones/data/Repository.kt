package com.example.gameofthrones.data

import com.example.gameofthrones.data.model.AllCharacters
import java.lang.Exception

class Repository {

    private val api = RetrofitInstance.thronesApi

    suspend fun getAllCharacters(): AllCharacters? {
        return try {
            api.getAllCharacters()
        } catch (e: Exception) {
            null
        }
    }
}