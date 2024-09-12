package com.example.composeApp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeApp.theme.AppTheme
import com.example.composeApp.theme.WatchEatTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun BaseToolbar(
    title: String
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(WatchEatTheme.colors.quartzBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title.uppercase(),
                fontWeight = FontWeight.Bold,
                color = WatchEatTheme.colors.whiteText
            )
        }
        MediumSpacer()
    }
}

@Preview
@Composable
internal fun BaseTopbarPreview() {
    AppTheme {
        BaseToolbar(
            title = "title"
        )
    }
}