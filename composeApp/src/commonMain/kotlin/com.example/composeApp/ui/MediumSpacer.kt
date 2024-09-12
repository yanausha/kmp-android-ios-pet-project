package com.example.composeApp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeApp.theme.WatchEatTheme

@Composable
internal fun MediumSpacer() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(2.dp)
            .background(WatchEatTheme.colors.tomatoElement)
    )
}

@Composable
internal fun NotColorSpacer() {
    Spacer(modifier = Modifier.height(4.dp))
}