package com.example.composeApp.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class WatchEatColors(
    val darkBrowmOliveText: Color,
    val whiteText: Color,
    val quartzBackground: Color,
    val almondBackground: Color,
    val sandBackground: Color,
    val orangeElement: Color,
    val ecruElement: Color,
    val tomatoElement: Color,
)

object WatchEatTheme {
    val colors: WatchEatColors
        @Composable
        get() = LocalAppColors.current
}

val darkColorScheme = WatchEatColors(
    darkBrowmOliveText = Color(0xFF241B13),
    whiteText = Color(0xFFFDFDFD),
    quartzBackground = Color(0xFF9AA58D),
    almondBackground = Color(0xFFF3DFCC),
    sandBackground = Color(0xFFE3CCBC),
    orangeElement = Color(0xFFFE964B),
    ecruElement = Color(0xFFCCB98B),
    tomatoElement = Color(0xFFA12312),
)

val LocalAppColors = staticCompositionLocalOf<WatchEatColors> { error("No default implementation for colors") }