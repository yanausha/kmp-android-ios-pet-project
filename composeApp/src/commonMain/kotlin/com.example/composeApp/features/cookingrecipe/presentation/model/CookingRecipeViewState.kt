package com.example.composeApp.features.cookingrecipe.presentation.model

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem

data class CookingRecipeViewState(
    val recipe: CookingRecipeItem = CookingRecipeItem(id = 0L)
)