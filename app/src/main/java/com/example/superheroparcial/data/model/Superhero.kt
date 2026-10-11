package com.example.superheroparcial.data.model

data class Superhero(
    val id: Int,
    val name: String,
    val publisher: String,
    val imageUrl: String,
    val stats: Map<String, Int>
)
