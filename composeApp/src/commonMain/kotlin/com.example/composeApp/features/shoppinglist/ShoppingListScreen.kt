package com.example.composeApp.features.shoppinglist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeApp.features.shoppinglist.model.ShoppingListEvent
import com.example.composeApp.navigations.LocalNavHost

@Composable
internal fun ShoppingListScreen(
    shoppingListViewModel: ShoppingListViewModel = viewModel { ShoppingListViewModel() }
) {
    val externalNacHost = LocalNavHost.current
    val viewState by shoppingListViewModel.viewState().collectAsState()
    val viewAction by shoppingListViewModel.viewAction().collectAsState(null)

    ShoppingListView(state = viewState) { event: ShoppingListEvent ->
        shoppingListViewModel.obtainEvent(event)
    }
}