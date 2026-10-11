package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroDetailSection(title: String, details: List<Pair<String, String>>) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(HeroPalette.White, RoundedCornerShape(18.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(title, color = HeroPalette.Ink, fontWeight = FontWeight.Bold, fontSize = 17.sp)
        val availableDetails = details.filter { it.second.isNotBlank() }
        if (availableDetails.isEmpty()) {
            Text("Información no disponible", color = HeroPalette.Muted, fontSize = 13.sp)
        } else {
            availableDetails.forEach { (label, value) ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = label,
                        color = HeroPalette.Muted,
                        fontSize = 13.sp,
                        modifier = Modifier.weight(0.4f)
                    )
                    Text(
                        text = value,
                        color = HeroPalette.Ink,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                        modifier = Modifier.weight(0.6f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDetailSectionPreview() {
    HeroDetailSection("Apariencia", listOf("Género" to "Male", "Altura" to "6'2 / 188 cm"))
}
