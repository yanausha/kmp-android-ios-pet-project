package com.example.composeApp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeApp.theme.WatchEatTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.go_back

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun GoBackIconButton(
    onBackClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        IconButton(onClick = onBackClicked) {
            Icon(
                painter = painterResource(Res.drawable.go_back),
                contentDescription = null,
                tint = WatchEatTheme.colors.whiteText
            )
        }
    }
}