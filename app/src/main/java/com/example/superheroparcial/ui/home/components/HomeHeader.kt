package com.example.superheroparcial.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Column(
            Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(horizontal = 22.dp, vertical = 25.dp)
        ) {
            Text(
                "Héroes",
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Black,
                fontSize = 32.sp
            )
            Text(
                "Descubre quién protege el universo",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = "Todos tus personajes favoritos, en un solo lugar",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 14.dp)
        )
    }
}
