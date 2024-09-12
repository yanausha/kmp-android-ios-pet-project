package com.example.composeApp.features.foodstuff.model

import com.example.composeApp.features.foodstuff.domain.FoodstuffItem

sealed class FoodstuffsEvent {
    class OnFoodstuffUpdate(val foodstuff: FoodstuffItem): FoodstuffsEvent()
    class OnFoodstuffDelete(val foodstuff: FoodstuffItem): FoodstuffsEvent()
}