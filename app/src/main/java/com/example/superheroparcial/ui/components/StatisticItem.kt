package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun StatisticItem(label: String, value: Int) {
    Column(Modifier.padding(vertical = 9.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label.replaceFirstChar { it.uppercase() }, color = HeroPalette.Ink,
                fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
            Text("${value.coerceIn(0, 100)} / 100", color = HeroPalette.Lavender,
                fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
        LinearProgressIndicator(
            progress = { (value / 100f).coerceIn(0f, 1f) },
            modifier = Modifier.fillMaxWidth(),
            color = HeroPalette.Coral,
            trackColor = HeroPalette.Track
        )
    }
}
@Preview(showBackground = true)
@Composable
fun StatisticItemPreview() { StatisticItem("Intelligence", 90) }
