package com.example.composeApp.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeApp.enums.ProductUnit
import com.example.composeApp.theme.WatchEatTheme
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@OptIn(
    ExperimentalResourceApi::class,
    ExperimentalMaterialApi::class
)
@Composable
internal fun ProductUnitDropdownMenu(
    unit: ProductUnit,
    modifier: Modifier = Modifier,
    onUnitChange: (ProductUnit) -> Unit,
) {
    val unitList = ProductUnit.entries.toList()
    var expanded by remember { mutableStateOf(false) }
    var unitValue by remember { mutableStateOf(unit) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 2.dp),
            enabled = false,
            value = stringResource(unitValue.textId),
            onValueChange = { },
            textStyle = TextStyle(
                color = WatchEatTheme.colors.darkBrowmOliveText,
                fontWeight = FontWeight.Bold,
            ),
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                textColor = WatchEatTheme.colors.darkBrowmOliveText,
                backgroundColor = WatchEatTheme.colors.whiteText,
                disabledIndicatorColor = WatchEatTheme.colors.ecruElement
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            unitList.forEach { unitItem ->
                DropdownMenuItem(
                    text = { Text(text = stringResource(unitItem.textId)) },
                    onClick = {
                        unitValue = unitItem
                        expanded = false
                    },

                    )
            }
        }
    }

    LaunchedEffect(unitValue) {
        delay(100L)
        onUnitChange(unitValue)
    }
}