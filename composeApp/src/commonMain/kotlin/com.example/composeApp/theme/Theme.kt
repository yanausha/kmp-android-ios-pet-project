package com.example.composeApp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalAppColors provides darkColorScheme,
        content = content
    )
}
