package com.example.superheroparcial.ui.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroparcial.data.repository.SuperheroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel class HomeViewModel @Inject constructor(private val repository: SuperheroRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()
    init { loadHeroes() }
    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun loadHeroes() { viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true, error = null) }
        repository.getAll().fold(
            onSuccess = { heroes -> _uiState.update { it.copy(heroes = heroes, isLoading = false) } },
            onFailure = { error -> _uiState.update { it.copy(isLoading = false, error = error.message) } }
        )
    } }
}
