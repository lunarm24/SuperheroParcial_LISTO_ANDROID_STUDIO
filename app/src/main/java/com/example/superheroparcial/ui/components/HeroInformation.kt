package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.preview.PreviewSuperhero

@Composable
fun HeroInformation(hero: Superhero) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        HeroDetailSection(
            title = "Apariencia",
            details = listOf(
                "Género" to hero.appearance.gender,
                "Raza" to hero.appearance.race,
                "Altura" to hero.appearance.height.joinToString(" / "),
                "Peso" to hero.appearance.weight.joinToString(" / "),
                "Color de ojos" to hero.appearance.eyeColor,
                "Color de cabello" to hero.appearance.hairColor
            )
        )
        HeroDetailSection(
            title = "Información adicional",
            details = listOf(
                "Nombre" to hero.fullName,
                "Editorial" to hero.publisher,
                "Lugar de nacimiento" to hero.biography.placeOfBirth,
                "Primera aparición" to hero.biography.firstAppearance,
                "Alineación" to hero.biography.alignment,
                "Ocupación" to hero.work.occupation,
                "Base" to hero.work.base,
                "Alias" to hero.biography.aliases.joinToString(", ")
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroInformationPreview() { HeroInformation(PreviewSuperhero.batman) }
