package com.example.superheroparcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HeroImage(
    url: String,
    name: String,
    modifier: Modifier = Modifier
) {
    val placeholder = painterResource(android.R.drawable.ic_menu_gallery)

    Box(modifier.clip(RoundedCornerShape(18.dp))
        .background(
            Brush.linearGradient(
                listOf(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.colorScheme.tertiaryContainer
                )
            )
        ),
        contentAlignment = Alignment.Center) {
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
@Preview(showBackground = true)
@Composable
fun HeroImagePreview() {
    SuperheroTheme {
        HeroImage("", "Superhéroe", Modifier.fillMaxWidth().height(210.dp))
    }
}
