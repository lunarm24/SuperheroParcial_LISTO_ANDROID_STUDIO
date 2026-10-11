package com.example.superheroparcial.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.superheroparcial.ui.components.HeroFullName
import com.example.superheroparcial.ui.components.HeroImage
import com.example.superheroparcial.ui.components.HeroName
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun SuperheroCard(
    hero: Superhero,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp)
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.primaryContainer),
                RoundedCornerShape(20.dp)
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
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
                HeroName(hero.name, fontSize = 17.sp)
                HeroFullName(hero.fullName)
                Text(
                    hero.publisher.ifBlank { "Editorial desconocida" },
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = "VER PERFIL",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 9.dp, vertical = 7.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuperheroCardPreview() {
    SuperheroTheme {
        SuperheroCard(
            Superhero(
                id = 69,
                name = "Batman",
                fullName = "Bruce Wayne",
                publisher = "DC Comics",
                imageUrl = "",
                stats = emptyMap()
            ),
            onClick = {}
        )
    }
}
