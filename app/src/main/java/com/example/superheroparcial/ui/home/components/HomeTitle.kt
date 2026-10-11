package com.example.superheroparcial.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HomeTitle(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .padding(horizontal = 22.dp, vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Héroes", color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Black, fontSize = 32.sp)
                Text("Descubre quién protege el universo",
                    color = MaterialTheme.colorScheme.onPrimary, fontSize = 15.sp)
            }
        }
        Text(
            text = "Todos tus personajes favoritos, en un solo lugar",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 14.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomeTitlePreview() {
    SuperheroTheme { HomeTitle() }
}
