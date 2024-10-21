package com.example.composeApp.features.cookingrecipes.presentation.model

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem

data class CookingRecipesViewState(
    val cookingRecipes: List<CookingRecipeItem> = emptyList(),
)