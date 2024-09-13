package com.example.composeApp.features.shoppinglist

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.shoppinglist.model.ShoppingListEvent
import com.example.composeApp.features.shoppinglist.model.ShoppingListViewState
import com.example.composeApp.ui.BaseToolbar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.shoppinglist

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun ShoppingListView(
    state: ShoppingListViewState,
    eventHandler: (ShoppingListEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(Res.string.shoppinglist)
            )
        }
    ) {}
}