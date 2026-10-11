package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun LoadingIndicator() {
    Column(Modifier.fillMaxWidth().padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)) {
        CircularProgressIndicator(color = HeroPalette.Lavender)
        Text("Reuniendo superpoderes…", color = HeroPalette.Ink,
            fontWeight = FontWeight.SemiBold)
    }
}
@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreview() { LoadingIndicator() }
