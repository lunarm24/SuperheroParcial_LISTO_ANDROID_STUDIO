package com.example.superheroparcial

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import com.example.superheroparcial.navigation.AppNavigation
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun SuperheroApp(modifier: Modifier = Modifier) {
    SuperheroTheme {
        val systemDensity = LocalDensity.current
        CompositionLocalProvider(
            LocalDensity provides Density(
                density = systemDensity.density,
                fontScale = systemDensity.fontScale * 1.08f
            )
        ) {
            AppNavigation(modifier = modifier.fillMaxSize())
        }
    }
}
