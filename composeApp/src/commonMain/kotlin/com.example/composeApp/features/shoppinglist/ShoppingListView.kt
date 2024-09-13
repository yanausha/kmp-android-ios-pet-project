package com.example.composeApp.features.shoppinglist

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.shoppinglist.model.ShoppingListEvent
import com.example.composeApp.features.shoppinglist.model.ShoppingListViewState
import com.example.composeApp.ui.BaseToolbar

@Composable
internal fun ShoppingListView(
    state: ShoppingListViewState,
    eventHandler: (ShoppingListEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                "Список покупок"
            )
        }
    ) {}
}