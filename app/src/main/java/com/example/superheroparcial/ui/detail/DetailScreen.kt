package com.example.superheroparcial.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.components.ErrorMessage
import com.example.superheroparcial.ui.detail.components.HeroHeader
import com.example.superheroparcial.ui.detail.components.HeroStatistics
import com.example.superheroparcial.ui.components.LoadingIndicator
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun DetailScreen(
    state: DetailUiState,
    onBack: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BackButton(onClick = onBack)
        when {
            state.isLoading -> LoadingIndicator()
            state.error != null -> ErrorMessage(state.error, onRetry)
            state.hero != null -> {
                HeroHeader(state.hero)
                HeroStatistics(state.hero.stats)
            }
            else -> ErrorMessage("No encontramos la información del superhéroe.", onRetry)
        }
    }
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(50))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Text(
            "←  VOLVER A HÉROES",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    SuperheroTheme {
        DetailScreen(
            DetailUiState(
                hero = Superhero(
                    id = 69,
                    name = "Batman",
                    publisher = "DC Comics",
                    imageUrl = "",
                    stats = mapOf("intelligence" to 100, "strength" to 26)
                ),
                isLoading = false
            ),
            onBack = {},
            onRetry = {}
        )
    }
}
