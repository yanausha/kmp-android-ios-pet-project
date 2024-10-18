package com.example.composeApp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeApp.theme.WatchEatTheme

@Composable
internal fun BaseButton(
    title: String,
    onClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
            colors = ButtonColors(
                containerColor = WatchEatTheme.colors.quartzBackground,
                contentColor = WatchEatTheme.colors.whiteText,
                disabledContainerColor = WatchEatTheme.colors.quartzBackground,
                disabledContentColor = WatchEatTheme.colors.whiteText,
            ),
            onClick = onClicked
        ) {
            Text(
                text = title.uppercase(),
                fontWeight = FontWeight.Bold,
                color = WatchEatTheme.colors.whiteText
            )
        }
    }
}