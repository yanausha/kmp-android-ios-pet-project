package com.example.composeApp.features.shoppinglist

import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.shoppinglist.model.ShoppingListAction
import com.example.composeApp.features.shoppinglist.model.ShoppingListEvent
import com.example.composeApp.features.shoppinglist.model.ShoppingListViewState

class ShoppingListViewModel :
    BaseViewModel<ShoppingListViewState, ShoppingListAction, ShoppingListEvent>(
        initialState = ShoppingListViewState()
    ) {
    override fun obtainEvent(viewEvent: ShoppingListEvent) {
        when (viewEvent) {

        }
    }
}