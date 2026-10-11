package com.example.superheroparcial.ui.detail

import com.example.superheroparcial.data.model.Superhero

data class DetailUiState(
    val hero: Superhero? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)
