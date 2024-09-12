package com.example.composeApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.example.composeApp.theme.WatchEatTheme

@Composable
internal fun DeleteImage(
    onDeleteClicked: () -> Unit
) {
    Image(
        modifier = Modifier.padding(4.dp).clickable { onDeleteClicked() },
        imageVector = Icons.Filled.Close,
        contentDescription = null,
        colorFilter = ColorFilter.tint(WatchEatTheme.colors.tomatoElement)
    )
}