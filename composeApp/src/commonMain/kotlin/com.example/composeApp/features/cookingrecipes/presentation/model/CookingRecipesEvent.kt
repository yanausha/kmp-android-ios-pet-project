package com.example.composeApp.features.cookingrecipes.presentation.model

sealed class CookingRecipesEvent {
    data object GoBackClicked : CookingRecipesEvent()
    data object CreateCookingRecipeClicked : CookingRecipesEvent()
}