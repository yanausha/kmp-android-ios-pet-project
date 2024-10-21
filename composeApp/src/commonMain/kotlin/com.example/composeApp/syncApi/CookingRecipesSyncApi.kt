package com.example.composeApp.syncApi

import kotlinx.coroutines.flow.Flow

interface CookingRecipesSyncApi {
    suspend fun getCookingRecipeList(): Flow<List<CookingRecipeSyncEntity>>

    suspend fun getCookingRecipeById(id: String): CookingRecipeSyncEntity

    suspend fun createCookingRecipe(cookingRecipe: CookingRecipeSyncEntity)
}