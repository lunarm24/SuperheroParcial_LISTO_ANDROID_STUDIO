package com.example.superheroparcial.ui.home

import com.example.superheroparcial.data.model.Superhero

data class HomeUiState(
    val heroes: List<Superhero> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = true,
    val error: String? = null
) {
    val filteredHeroes: List<Superhero>
        get() = heroes.filter { hero ->
            hero.name.contains(searchQuery, ignoreCase = true) ||
                hero.fullName.contains(searchQuery, ignoreCase = true) ||
                hero.publisher.contains(searchQuery, ignoreCase = true)
        }
}
