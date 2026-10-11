package com.example.superheroparcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroStatistics(stats: Map<String, Int>) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp)
        .background(HeroPalette.White, RoundedCornerShape(24.dp)).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text("ESTADÍSTICAS", color = HeroPalette.Lavender,
            fontWeight = FontWeight.ExtraBold, fontSize = 11.sp, letterSpacing = 1.sp)
        Text("Nivel de poder", color = HeroPalette.Ink,
            fontWeight = FontWeight.Black, fontSize = 22.sp)
        stats.forEach { (label, value) -> StatisticItem(label, value) }
    }
}
@Preview(showBackground = true)
@Composable
fun HeroStatisticsPreview() { HeroStatistics(PreviewSuperhero.batman.stats) }
