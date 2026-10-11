package com.example.superheroparcial.ui.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeroStatistics(stats: Map<String, Int>, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(24.dp)).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            "ESTADÍSTICAS",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 11.sp,
            letterSpacing = 1.sp
        )
        Text(
            "Nivel de poder",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Black,
            fontSize = 22.sp
        )
        stats.forEach { (label, value) -> StatisticItem(label, value) }
    }
}

@Composable
fun StatisticItem(label: String, value: Int, modifier: Modifier = Modifier) {
    Column(
        modifier.padding(vertical = 9.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                label.replaceFirstChar { it.uppercase() },
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp
            )
            Text(
                "${value.coerceIn(0, 100)} / 100",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                textAlign = TextAlign.End
            )
        }
        LinearProgressIndicator(
            progress = { (value / 100f).coerceIn(0f, 1f) },
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.outlineVariant
        )
    }
}
