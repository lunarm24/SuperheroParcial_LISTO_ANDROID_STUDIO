package com.example.superheroparcial.data.source
import com.example.superheroparcial.data.model.SuperheroDto
interface SuperheroDataSource { suspend fun getAll(): List<SuperheroDto>; suspend fun getById(id: Int): SuperheroDto }
