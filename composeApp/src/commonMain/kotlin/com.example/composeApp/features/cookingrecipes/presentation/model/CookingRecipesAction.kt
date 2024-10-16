package com.example.composeApp.features.cookingrecipes.presentation.model

sealed class CookingRecipesAction {
    data object GoBack : CookingRecipesAction()
    data object CreateCookingRecipe : CookingRecipesAction()
}