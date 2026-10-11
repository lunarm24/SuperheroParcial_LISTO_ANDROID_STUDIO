package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroHeader(hero: Superhero) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("✦  EXPEDIENTE DEL MULTIVERSO", color = HeroPalette.Lavender,
            fontWeight = FontWeight.ExtraBold, fontSize = 11.sp, letterSpacing = 1.sp)
        HeroImage(
            url = hero.imageUrl,
            name = hero.name,
            modifier = Modifier.fillMaxWidth().height(280.dp)
        )
        HeroPublisher(hero.publisher)
        HeroName(hero.name)
        HeroFullName(hero.fullName)
    }
}
@Preview(showBackground = true)
@Composable
fun HeroHeaderPreview() { HeroHeader(PreviewSuperhero.batman) }
