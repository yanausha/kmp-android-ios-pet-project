package com.example.composeApp.features.foodstuff.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeApp.enums.ProductUnit
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.composeApp.features.foodstuff.presentation.model.FoodstuffsEvent
import com.example.composeApp.features.foodstuff.presentation.model.FoodstuffsViewState
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.DeleteImage
import com.example.composeApp.ui.InputIntText
import com.example.composeApp.ui.InputText
import com.example.composeApp.ui.NotColorSpacer
import com.example.composeApp.ui.PlusIconButton
import com.example.composeApp.ui.ProductUnitDropdownMenu
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.change_count
import watcheat.composeapp.generated.resources.foodstuffs
import watcheat.composeapp.generated.resources.hint_name

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun FoodstuffsView(
    state: FoodstuffsViewState,
    eventHandler: (FoodstuffsEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(Res.string.foodstuffs),
            ) {
                PlusIconButton {
                    eventHandler.invoke(FoodstuffsEvent.CreateItemClicked)
                }
            }
        },
    ) { paddingValues ->
        Content(
            list = state.foodstuffs,
            paddingValues = paddingValues,
            onUpdateItemClicked = { eventHandler.invoke(FoodstuffsEvent.OnFoodstuffUpdate(it)) },
            onDeleteItemClicked = { eventHandler.invoke(FoodstuffsEvent.OnFoodstuffDelete(it)) },
        )
    }
}

@Composable
private fun Content(
    list: List<FoodstuffItem>,
    paddingValues: PaddingValues,
    onUpdateItemClicked: (FoodstuffItem) -> Unit,
    onDeleteItemClicked: (FoodstuffItem) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentPadding = paddingValues,
    ) {
        items(list) { item ->
            key(item.id) {
                FoodItem(
                    foodstuff = item,
                    onFoodNameChange = { onUpdateItemClicked(item.copy(name = it)) },
                    onFoodCountChange = { onUpdateItemClicked(item.copy(count = it)) },
                    onUnitChange = { onUpdateItemClicked(item.copy(unit = it)) },
                    onDeleteFoodClicked = { onDeleteItemClicked(item) },
                )
                NotColorSpacer()
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun FoodItem(
    foodstuff: FoodstuffItem,
    onFoodNameChange: (String) -> Unit,
    onFoodCountChange: (Int) -> Unit,
    onUnitChange: (ProductUnit) -> Unit,
    onDeleteFoodClicked: () -> Unit
) {
    Row(
        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        InputText(
            value = foodstuff.name,
            hint = stringResource(Res.string.hint_name),
            modifier = Modifier.weight(3f),
            onValueChange = onFoodNameChange
        )
        InputIntText(
            value = stringResource(Res.string.change_count, foodstuff.count),
            modifier = Modifier.weight(1f),
            onValueChange = onFoodCountChange
        )
        ProductUnitDropdownMenu(
            unit = foodstuff.unit,
            modifier = Modifier.weight(1f),
            onUnitChange = onUnitChange,
        )
        DeleteImage(onDeleteClicked = onDeleteFoodClicked)
        NotColorSpacer()
    }
}