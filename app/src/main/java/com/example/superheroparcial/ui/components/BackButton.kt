package com.example.superheroparcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun BackButton(onClick: () -> Unit) {
    Row(Modifier.padding(20.dp).background(HeroPalette.LavenderLight, RoundedCornerShape(50))
        .clickable(onClick = onClick).padding(horizontal = 16.dp, vertical = 11.dp)) {
        Text("←  VOLVER AL UNIVERSO", color = HeroPalette.Lavender,
            fontWeight = FontWeight.ExtraBold)
    }
}
@Preview(showBackground = true)
@Composable
fun BackButtonPreview() { BackButton({}) }
