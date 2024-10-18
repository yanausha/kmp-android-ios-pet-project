package com.example.composeApp.features.cookingrecipe.presentation.model

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem

sealed class CookingRecipeEvent {
    data object GoBackClicked : CookingRecipeEvent()
    data class OnRecipeUpdated(val recipe: CookingRecipeItem) : CookingRecipeEvent()
    data object AddIngredientsClicked : CookingRecipeEvent()
    data object OnCreateClicked: CookingRecipeEvent()
}