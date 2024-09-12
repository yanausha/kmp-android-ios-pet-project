package com.example.composeApp.features.foodstuff

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.composeApp.features.foodstuff.model.FoodstuffsEvent
import com.example.composeApp.features.foodstuff.model.FoodstuffsViewState
import com.example.composeApp.theme.AppTheme
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.DeleteImage
import com.example.composeApp.ui.InputIntText
import com.example.composeApp.ui.InputText
import com.example.composeApp.ui.NotColorSpacer
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun FoodstuffsView(
    state: FoodstuffsViewState,
    eventHandler: (FoodstuffsEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = "Продукты"
            )
        },
        bottomBar = {},
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color.White),
            contentPadding = it
        ) {
            items(state.foodstuffs) { item ->
                FoodItem(
                    foodstuff = item,
                    onFoodNameChange = { name -> eventHandler.invoke(FoodstuffsEvent.OnFoodstuffUpdate(item.copy(name = name))) },
                    onFoodCountChange = { count -> eventHandler.invoke(FoodstuffsEvent.OnFoodstuffUpdate(item.copy(count = count))) },
                    onDeleteFoodClicked = { eventHandler.invoke(FoodstuffsEvent.OnFoodstuffDelete(item)) }
                )
                NotColorSpacer()
            }
        }
    }
}

@Composable
private fun FoodItem(
    foodstuff: FoodstuffItem,
    onFoodNameChange: (String) -> Unit,
    onFoodCountChange: (Int) -> Unit,
    onDeleteFoodClicked: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InputText(
                value = foodstuff.name.orEmpty(),
                hint = "Название",
                modifier = Modifier.weight(3f),
                onValueChange = onFoodNameChange
            )
            InputIntText(
                value = "${foodstuff.count}",
                modifier = Modifier.weight(1f),
                onValueChange = onFoodCountChange
            )
            DeleteImage(onDeleteClicked = onDeleteFoodClicked)
            NotColorSpacer()
        }
    }
}

@Preview
@Composable
internal fun FoodstuffsViewPreview() {
    AppTheme {
        FoodstuffsView(
            state = FoodstuffsViewState(
                foodstuffs = listOf(
                    FoodstuffItem(
                        id = "0",
                        name = "Apple",
                        count = 1
                    ),
                    FoodstuffItem(
                        id = "1",
                        name = null,
                        count = null
                    ),
                )
            ),
            eventHandler = {}
        )
    }
}