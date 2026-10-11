package com.example.superheroparcial.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroparcial.data.repository.SuperheroRepository
import com.example.superheroparcial.data.model.Superhero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

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

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SuperheroRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadHeroes()
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun loadHeroes() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            repository.getAll().fold(
                onSuccess = { heroes ->
                    _uiState.update { it.copy(heroes = heroes, isLoading = false) }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(isLoading = false, error = error.message) }
                }
            )
        }
    }
}
