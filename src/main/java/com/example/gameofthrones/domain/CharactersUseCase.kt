package com.example.gameofthrones.domain

import com.example.gameofthrones.data.Repository
import com.example.gameofthrones.data.model.AllCharacters

class CharactersUseCase {

    private val repository = Repository()

    suspend fun getAllCharacters(): AllCharacters? {
        return repository.getAllCharacters()
    }
}