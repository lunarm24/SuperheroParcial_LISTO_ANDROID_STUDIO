package com.example.superheroparcial.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.data.repository.SuperheroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DetailUiState(
    val hero: Superhero? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: SuperheroRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    fun loadHero(id: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(hero = null, isLoading = true, error = null) }
            repository.getById(id).fold(
                onSuccess = { hero ->
                    _uiState.update { it.copy(hero = hero, isLoading = false) }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(isLoading = false, error = error.message) }
                }
            )
        }
    }
}
