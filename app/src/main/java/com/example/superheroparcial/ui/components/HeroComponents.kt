package com.example.superheroparcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

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

@Composable
fun HeroImage(
    url: String,
    name: String,
    modifier: Modifier = Modifier
) {
    val placeholder = painterResource(android.R.drawable.ic_menu_gallery)

    Box(
        modifier.clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = url,
            contentDescription = "Imagen de $name",
            placeholder = placeholder,
            error = placeholder,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
