package com.example.superheroparcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroImage(
    url: String,
    name: String,
    modifier: Modifier = Modifier.fillMaxWidth().height(210.dp)
) {
    Box(modifier.clip(RoundedCornerShape(18.dp))
        .background(Brush.linearGradient(listOf(HeroPalette.LavenderLight, HeroPalette.Peach))),
        contentAlignment = Alignment.Center) {
        Text("✦", color = HeroPalette.Lavender, fontWeight = FontWeight.Black, fontSize = 64.sp)
        AsyncImage(
            model = url,
            contentDescription = "Imagen de $name",
            error = painterResource(android.R.drawable.ic_menu_gallery),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HeroImagePreview() { HeroImage("", "Superhéroe") }
