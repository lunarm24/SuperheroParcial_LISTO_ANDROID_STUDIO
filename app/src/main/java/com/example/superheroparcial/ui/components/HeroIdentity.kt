package com.example.superheroparcial.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HeroName(
    name: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 23.sp
) {
    Text(
        name,
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = FontWeight.Black,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Preview(showBackground = true)
@Composable
fun HeroNamePreview() {
    SuperheroTheme { HeroName("Batman") }
}

@Composable
fun HeroFullName(fullName: String, modifier: Modifier = Modifier) {
    Text(
        fullName.ifBlank { "Identidad secreta" },
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp
    )
}

@Preview(showBackground = true)
@Composable
fun HeroFullNamePreview() {
    SuperheroTheme { HeroFullName("Bruce Wayne") }
}
