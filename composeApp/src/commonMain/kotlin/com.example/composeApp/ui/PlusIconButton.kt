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
import watcheat.composeapp.generated.resources.plus

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun PlusIconButton(
    onPlusClicked: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        IconButton(onClick = onPlusClicked) {
            Icon(
                painter = painterResource(Res.drawable.plus),
                contentDescription = null,
                tint = WatchEatTheme.colors.whiteText
            )
        }
    }
}