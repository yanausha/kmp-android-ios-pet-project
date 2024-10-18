package com.example.composeApp.features.cookingrecipe.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class CookingRecipeInteractor(
    private val cookingRecipeRepository: CookingRecipeRepository
) {
    suspend fun create(recipe: CookingRecipeItem) = withContext(Dispatchers.IO) {
        cookingRecipeRepository.create(recipe)
    }
}