package com.example.composeApp.features.cookingrecipe.presentation.model

sealed class CookingRecipeEvent {
    data object GoBackClicked : CookingRecipeEvent()
}