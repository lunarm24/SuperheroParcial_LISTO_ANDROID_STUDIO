package com.example.superheroparcial.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.components.ErrorMessage
import com.example.superheroparcial.ui.components.LoadingIndicator
import com.example.superheroparcial.ui.home.components.HomeHeader
import com.example.superheroparcial.ui.home.components.SuperheroList
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HomeScreen(
    state: HomeUiState,
    onHeroClick: (Int) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        HomeHeader(
            searchQuery = state.searchQuery,
            onSearchQueryChange = onSearchQueryChange
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

@Composable
private fun HomeEmptyState(message: String) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeEmptyStatePreview() {
    SuperheroTheme {
        HomeEmptyState("No encontramos superhéroes.")
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomeScreenPreview() {
    SuperheroTheme {
        HomeScreen(
            HomeUiState(
                heroes = listOf(
                    Superhero(
                        id = 69,
                        name = "Batman",
                        fullName = "Bruce Wayne",
                        publisher = "DC Comics",
                        imageUrl = "",
                        stats = emptyMap()
                    )
                ),
                isLoading = false
            ),
            onHeroClick = {},
            onSearchQueryChange = {},
            onRetry = {}
        )
    }
}
