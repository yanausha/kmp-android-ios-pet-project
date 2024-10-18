package com.example.composeApp.features.cookingrecipe.presentation.model

sealed class CookingRecipeAction {
    data object GoBack : CookingRecipeAction()
    data object AddIngredients : CookingRecipeAction()
}