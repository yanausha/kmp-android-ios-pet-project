package com.example.composeApp.features.foodstuff.presentation.model

import com.example.composeApp.features.foodstuff.domain.FoodstuffItem

sealed class FoodstuffsEvent {
    class OnFoodstuffUpdate(val foodstuff: FoodstuffItem): FoodstuffsEvent()
    class OnFoodstuffDelete(val foodstuff: FoodstuffItem): FoodstuffsEvent()
    data object CreateItemClicked: FoodstuffsEvent()
}