package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun SuperheroCard(hero: Superhero, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 5.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = HeroPalette.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            HeroImage(
                url = hero.imageUrl,
                name = hero.name,
                modifier = Modifier.size(68.dp)
            )
            Column(
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                HeroName(hero.name, fontSize = 16.sp)
                HeroFullName(hero.fullName)
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("✦", color = HeroPalette.Lavender, fontSize = 12.sp)
                    Text(
                        hero.publisher.ifBlank { "Editorial desconocida" },
                        color = HeroPalette.Muted,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Text(
                text = "›",
                color = HeroPalette.Muted,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuperheroCardPreview() { SuperheroCard(PreviewSuperhero.batman, {}) }
