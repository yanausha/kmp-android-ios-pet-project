package com.example.composeApp.features.foodstuff.presentation.model

import com.example.composeApp.features.foodstuff.domain.FoodstuffItem

data class FoodstuffsViewState(val foodstuffs: List<FoodstuffItem> = listOf())