package com.example.superheroparcial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = HeroLavender,
    onPrimary = HeroWhite,
    primaryContainer = HeroLavenderLight,
    onPrimaryContainer = HeroInk,
    secondary = HeroCoral,
    onSecondary = HeroInk,
    secondaryContainer = HeroLilacSurface,
    onSecondaryContainer = HeroInk,
    tertiary = HeroLavender,
    tertiaryContainer = HeroPeach,
    onTertiaryContainer = HeroInk,
    background = HeroCream,
    onBackground = HeroInk,
    surface = HeroWhite,
    onSurface = HeroInk,
    surfaceVariant = HeroLilacSurface,
    onSurfaceVariant = HeroMuted,
    outlineVariant = HeroTrack
)

private val DarkColors = darkColorScheme(
    primary = HeroDarkLavender,
    onPrimary = HeroDarkCream,
    primaryContainer = HeroDarkLavenderContainer,
    onPrimaryContainer = HeroDarkInk,
    secondary = HeroDarkCoral,
    onSecondary = HeroDarkCream,
    secondaryContainer = HeroDarkLavenderContainer,
    onSecondaryContainer = HeroDarkInk,
    tertiary = HeroDarkCoral,
    tertiaryContainer = HeroDarkPeach,
    onTertiaryContainer = HeroDarkInk,
    background = HeroDarkCream,
    onBackground = HeroDarkInk,
    surface = HeroDarkWhite,
    onSurface = HeroDarkInk,
    surfaceVariant = HeroDarkLilacSurface,
    onSurfaceVariant = HeroDarkMuted,
    outlineVariant = HeroDarkTrack
)

@Composable
fun SuperheroTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
