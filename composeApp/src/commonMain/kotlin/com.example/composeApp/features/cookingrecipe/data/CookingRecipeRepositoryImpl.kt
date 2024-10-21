package com.example.composeApp.features.cookingrecipe.data

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeRepository
import com.example.composeApp.syncApi.CookingRecipesSyncApi

class CookingRecipeRepositoryImpl(
    private val cookingRecipesSyncApi: CookingRecipesSyncApi
) : CookingRecipeRepository {

    override suspend fun create(recipe: CookingRecipeItem) {
        cookingRecipesSyncApi.createCookingRecipe(recipe.toSyncEntity())
    }
}