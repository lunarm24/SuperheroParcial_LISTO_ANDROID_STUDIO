package com.example.superheroparcial.ui.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HeroStatistics(stats: Map<String, Int>, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp)
        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(24.dp)).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text("ESTADÍSTICAS", color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold, fontSize = 11.sp, letterSpacing = 1.sp)
        Text("Nivel de poder", color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Black, fontSize = 22.sp)
        stats.forEach { (label, value) -> StatisticItem(label, value) }
    }
}
@Preview(showBackground = true)
@Composable
fun HeroStatisticsPreview() {
    SuperheroTheme {
        HeroStatistics(
            mapOf(
                "intelligence" to 100,
                "strength" to 26,
                "combat" to 100
            )
        )
    }
}
