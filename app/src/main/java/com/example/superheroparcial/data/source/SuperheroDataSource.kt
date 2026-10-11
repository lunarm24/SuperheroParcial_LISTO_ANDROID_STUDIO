package com.example.superheroparcial.data.source

import com.example.superheroparcial.data.DTO.SuperheroDto

interface SuperheroDataSource {
    suspend fun getAll(): List<SuperheroDto>

    suspend fun getById(id: Int): SuperheroDto
}
