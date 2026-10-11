package com.example.superheroparcial.data.repository
import com.example.superheroparcial.data.model.Superhero
interface SuperheroRepository { suspend fun getAll(): Result<List<Superhero>>; suspend fun getById(id: Int): Result<Superhero> }
