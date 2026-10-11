package com.example.superheroparcial.ui.home.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun SuperheroList(
    heroes: List<Superhero>,
    onHeroClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        items(heroes, key = { it.id }) { hero ->
            SuperheroCard(
                hero = hero,
                onClick = { onHeroClick(hero.id) }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuperheroListPreview() {
    SuperheroTheme {
        SuperheroList(
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
            onHeroClick = {}
        )
    }
}
