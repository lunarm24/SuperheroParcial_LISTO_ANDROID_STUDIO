package com.example.superheroparcial.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.components.HeroImage
import com.example.superheroparcial.ui.components.HeroName

@Composable
fun SuperheroCard(
    hero: Superhero,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp)
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
                HeroName(hero.name, hero.fullName, fontSize = 17.sp)
                Text(
                    hero.publisher.ifBlank { "Editorial desconocida" },
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
