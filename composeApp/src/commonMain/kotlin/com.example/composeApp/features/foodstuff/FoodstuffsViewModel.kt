package com.example.composeApp.features.foodstuff

import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.foodstuff.model.FoodstuffsAction
import com.example.composeApp.features.foodstuff.model.FoodstuffsEvent
import com.example.composeApp.features.foodstuff.model.FoodstuffsViewState

class FoodstuffsViewModel :
    BaseViewModel<FoodstuffsViewState, FoodstuffsAction, FoodstuffsEvent>(initialState = FoodstuffsViewState()) {
    override fun obtainEvent(viewEvent: FoodstuffsEvent) {
        when (viewEvent) {
            is FoodstuffsEvent.OnFoodstuffDelete -> {}
            is FoodstuffsEvent.OnFoodstuffUpdate -> {}
        }
    }
}