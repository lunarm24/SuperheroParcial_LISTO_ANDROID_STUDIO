package com.example.superheroparcial.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.preview.PreviewSuperhero

@Composable
fun SuperheroList(heroes: List<Superhero>, onHeroClick: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(bottom = 24.dp)) {
        items(heroes, key = { it.id }) { hero ->
            SuperheroCard(hero) { onHeroClick(hero.id) }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuperheroListPreview() { SuperheroList(PreviewSuperhero.heroes, {}) }
