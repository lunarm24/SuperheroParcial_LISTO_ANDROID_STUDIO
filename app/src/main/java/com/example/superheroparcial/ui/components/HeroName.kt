package com.example.superheroparcial.ui.components
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroName(name: String, fontSize: TextUnit = 23.sp) {
    Text(name, fontSize = fontSize, fontWeight = FontWeight.Black, color = HeroPalette.Ink)
}
@Preview(showBackground = true)
@Composable
fun HeroNamePreview() { HeroName(PreviewSuperhero.batman.name) }
