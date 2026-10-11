package com.example.superheroparcial.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.components.ErrorMessage
import com.example.superheroparcial.ui.components.LoadingIndicator
import com.example.superheroparcial.ui.home.components.HomeHeader
import com.example.superheroparcial.ui.home.components.SuperheroCard
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HomeScreen(
    state: HomeUiState,
    onHeroClick: (Int) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        HomeHeader(modifier = Modifier.fillMaxWidth())
        when {
            state.isLoading -> LoadingIndicator()
            state.error != null -> ErrorMessage(state.error, onRetry)
            state.heroes.isEmpty() -> Text(
                text = "No hay superhéroes disponibles.",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth().padding(32.dp)
            )
            else -> LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(state.heroes, key = { it.id }) { hero ->
                    SuperheroCard(hero) { onHeroClick(hero.id) }
                }
            }
        }
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
                        publisher = "DC Comics",
                        imageUrl = "",
                        stats = emptyMap()
                    )
                ),
                isLoading = false
            ),
            onHeroClick = {},
            onRetry = {}
        )
    }
}
