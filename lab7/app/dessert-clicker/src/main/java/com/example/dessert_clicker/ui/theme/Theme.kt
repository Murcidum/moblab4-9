package com.example.dessert_clicker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Material 3 использует ColorScheme вместо Colors
private val DarkColorScheme = darkColorScheme(
    primary = Purple200,
    primaryContainer = Purple700,
    secondary = Pink600
)

private val LightColorScheme = lightColorScheme(
    primary = Green600,
    primaryContainer = Purple700,
    secondary = Pink600
)

@Composable
fun DessertClickerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,  // В Material 3: colorScheme вместо colors
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}