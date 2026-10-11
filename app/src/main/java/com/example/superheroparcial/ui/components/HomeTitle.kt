package com.example.superheroparcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HomeTitle() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(HeroPalette.Lavender, Color(0xFF9B83E8))
                    )
                )
                .padding(horizontal = 22.dp, vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("UNIVERSO", color = HeroPalette.LavenderLight,
                    fontWeight = FontWeight.Bold, fontSize = 11.sp, letterSpacing = 2.sp)
                Text("Héroes", color = HeroPalette.White,
                    fontWeight = FontWeight.Black, fontSize = 30.sp)
                Text("Descubre quién protege el universo",
                    color = HeroPalette.White, fontSize = 14.sp)
            }
        }
        Text(
            text = "Todos tus personajes favoritos, en un solo lugar",
            color = HeroPalette.Muted,
            fontSize = 13.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 18.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomeTitlePreview() { HomeTitle() }
