package com.example.composeApp.features.cookingrecipes.domain

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class CookingRecipesInteractor(
    private val cookingRecipesRepository: CookingRecipesRepository
) {

    suspend fun getCookingRecipes(): Flow<List<CookingRecipeItem>> =
        cookingRecipesRepository.getAll().flowOn(Dispatchers.IO)

}