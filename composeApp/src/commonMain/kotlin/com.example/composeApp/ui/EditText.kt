package com.example.composeApp.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.composeApp.theme.WatchEatTheme
import kotlinx.coroutines.delay

@Composable
internal fun InputText(
    value: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    var name by remember { mutableStateOf(value) }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp),
        value = name,
        onValueChange = { name = it },
        textStyle = TextStyle(
            color = WatchEatTheme.colors.darkBrowmOliveText,
            fontWeight = FontWeight.Bold,
        ),
        placeholder = {
            Text(
                text = hint,
                color = WatchEatTheme.colors.ecruElement,
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = WatchEatTheme.colors.whiteText,
            unfocusedTextColor = WatchEatTheme.colors.darkBrowmOliveText,
            focusedContainerColor = WatchEatTheme.colors.whiteText,
            focusedTextColor = WatchEatTheme.colors.darkBrowmOliveText,
            cursorColor = WatchEatTheme.colors.ecruElement,
            focusedIndicatorColor = WatchEatTheme.colors.ecruElement,
            unfocusedIndicatorColor = WatchEatTheme.colors.ecruElement,
        ),
    )

    LaunchedEffect(name) {
        delay(100L)
        onValueChange(name)
    }
}

@Composable
internal fun InputIntText(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit
) {
    var count by remember { mutableStateOf(value) }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp),
        value = count,
        onValueChange = { countValue ->
            count = if (countValue.isNotEmpty()) countValue.filter { it.isDigit() } else ""
        },
        textStyle = TextStyle(
            color = WatchEatTheme.colors.darkBrowmOliveText,
            fontWeight = FontWeight.Bold
        ),
        placeholder = {
            Text(
                text = "0",
                color = WatchEatTheme.colors.ecruElement
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = WatchEatTheme.colors.whiteText,
            unfocusedTextColor = WatchEatTheme.colors.darkBrowmOliveText,
            focusedContainerColor = WatchEatTheme.colors.whiteText,
            focusedTextColor = WatchEatTheme.colors.darkBrowmOliveText,
            cursorColor = WatchEatTheme.colors.ecruElement,
            focusedIndicatorColor = WatchEatTheme.colors.ecruElement,
            unfocusedIndicatorColor = WatchEatTheme.colors.ecruElement,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
    )

    LaunchedEffect(count) {
        delay(100L)
        if (count.isNotBlank()) onValueChange(count.toInt())
    }
}