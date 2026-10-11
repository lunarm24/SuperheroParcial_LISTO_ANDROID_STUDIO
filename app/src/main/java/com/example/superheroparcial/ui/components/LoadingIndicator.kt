package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth().padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        Text("Reuniendo superpoderes…", color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.SemiBold)
    }
}
@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreview() {
    SuperheroTheme { LoadingIndicator() }
}
