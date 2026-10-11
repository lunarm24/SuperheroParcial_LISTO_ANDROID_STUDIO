package com.example.superheroparcial.ui.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun BackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(50))
        .clickable(onClick = onClick).padding(horizontal = 12.dp, vertical = 10.dp)) {
        Text("←  VOLVER A HÉROES", color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold)
    }
}
@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    SuperheroTheme { BackButton({}) }
}
