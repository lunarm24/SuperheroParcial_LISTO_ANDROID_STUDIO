package com.example.superheroparcial.ui.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.components.HeroFullName
import com.example.superheroparcial.ui.components.HeroImage
import com.example.superheroparcial.ui.components.HeroName
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HeroHeader(hero: Superhero, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        HeroImage(
            url = hero.imageUrl,
            name = hero.name,
            modifier = Modifier.fillMaxWidth().height(280.dp)
        )
        Column(
            Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(20.dp))
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            HeroPublisher(hero.publisher)
            HeroName(hero.name)
            HeroFullName(hero.fullName)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HeroHeaderPreview() {
    SuperheroTheme {
        HeroHeader(
            Superhero(
                id = 69,
                name = "Batman",
                fullName = "Bruce Wayne",
                publisher = "DC Comics",
                imageUrl = "",
                stats = emptyMap()
            )
        )
    }
}
