package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroHeader(hero: Superhero) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        HeroImage(
            url = hero.imageUrl,
            name = hero.name,
            modifier = Modifier.fillMaxWidth().height(280.dp)
        )
        Column(
            Modifier.fillMaxWidth().background(HeroPalette.LavenderLight, RoundedCornerShape(20.dp))
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
fun HeroHeaderPreview() { HeroHeader(PreviewSuperhero.batman) }
