package com.example.superheroparcial.ui.home.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.components.HeroFullName
import com.example.superheroparcial.ui.components.HeroImage
import com.example.superheroparcial.ui.components.HeroName
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Column(
            Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(horizontal = 22.dp, vertical = 25.dp)
        ) {
            Text(
                "Héroes",
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Black,
                fontSize = 32.sp
            )
            Text(
                "Descubre quién protege el universo",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = "Todos tus personajes favoritos, en un solo lugar",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 14.dp)
        )
    }
}

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
                HeroName(hero.name, fontSize = 17.sp)
                HeroFullName(hero.fullName)
                Text(
                    hero.publisher.ifBlank { "Editorial desconocida" },
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
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
