package com.example.superheroparcial.ui.home

import com.example.superheroparcial.data.model.Superhero

data class HomeUiState(
    val heroes: List<Superhero> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
