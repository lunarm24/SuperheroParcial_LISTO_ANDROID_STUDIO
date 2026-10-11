package com.example.superheroparcial.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.components.ErrorMessage
import com.example.superheroparcial.ui.components.HomeEmptyState
import com.example.superheroparcial.ui.components.HomeTitle
import com.example.superheroparcial.ui.components.HeroSearchField
import com.example.superheroparcial.ui.components.LoadingIndicator
import com.example.superheroparcial.ui.components.SuperheroList
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HomeScreen(
    state: HomeUiState,
    onHeroClick: (Int) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize().background(HeroPalette.Cream)) {
        HomeTitle()
        HeroSearchField(
            value = state.searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )
        when {
            state.isLoading -> LoadingIndicator()
            state.error != null -> ErrorMessage(state.error, onRetry)
            state.filteredHeroes.isEmpty() -> HomeEmptyState(
                if (state.searchQuery.isBlank()) "No hay superhéroes disponibles."
                else "No encontramos coincidencias."
            )
            else -> SuperheroList(state.filteredHeroes, onHeroClick)
        }
    }
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            HomeUiState(heroes = PreviewSuperhero.heroes, isLoading = false),
            onHeroClick = {},
            onSearchQueryChange = {},
            onRetry = {}
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomeLoadingPreview() {
    HomeScreen(HomeUiState(isLoading = true), {}, {}, {})
}
@Preview(showBackground = true)
@Composable
fun HomeErrorPreview() {
    HomeScreen(HomeUiState(isLoading = false, error = "Sin conexión"), {}, {}, {})
}
