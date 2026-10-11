package com.example.superheroparcial.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val HeroInk = Color(0xFF251A3D)
val HeroMuted = Color(0xFF786F87)
val HeroLavender = Color(0xFF7554D6)
val HeroLavenderLight = Color(0xFFEAE2FF)
val HeroCoral = Color(0xFFB394F5)
val HeroPeach = Color(0xFFF4ECFF)
val HeroCream = Color(0xFFF8F6FC)
val HeroWhite = Color(0xFFFFFFFF)
val HeroLilacSurface = Color(0xFFF0EBFA)
val HeroTrack = Color(0xFFE7E1F0)

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

@Composable
fun SuperheroTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
