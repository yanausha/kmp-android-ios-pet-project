package com.example.composeApp.features.cookingrecipe.domain

interface CookingRecipeRepository {
    suspend fun create(recipe: CookingRecipeItem)
}