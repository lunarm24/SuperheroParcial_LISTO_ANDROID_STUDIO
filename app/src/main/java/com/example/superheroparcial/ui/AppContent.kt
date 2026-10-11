package com.example.superheroparcial.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.superheroparcial.navigation.AppNavigation
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun AppContent() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = HeroPalette.Lavender,
            secondary = HeroPalette.Coral,
            background = HeroPalette.Cream,
            surface = HeroPalette.White,
            onSurface = HeroPalette.Ink,
            onBackground = HeroPalette.Ink
        )
    ) {
        Scaffold(containerColor = HeroPalette.Cream) { padding ->
            Box(Modifier.fillMaxSize().padding(padding)) {
                AppNavigation(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
