package com.example.superheroparcial.ui.components
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroFullName(fullName: String) {
    Text(fullName.ifBlank { "Identidad secreta" },
        color = HeroPalette.Muted, fontWeight = FontWeight.Medium, fontSize = 13.sp)
}
@Preview(showBackground = true)
@Composable
fun HeroFullNamePreview() { HeroFullName(PreviewSuperhero.batman.fullName) }
