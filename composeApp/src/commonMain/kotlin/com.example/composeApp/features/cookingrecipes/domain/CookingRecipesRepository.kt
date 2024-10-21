package com.example.composeApp.features.cookingrecipes.domain

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import kotlinx.coroutines.flow.Flow

interface CookingRecipesRepository {
    suspend fun getAll(): Flow<List<CookingRecipeItem>>
}