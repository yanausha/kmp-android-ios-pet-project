package com.example.composeApp.features.cookingrecipe.data

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeRepository
import com.example.syncApi.CookingRecipesSyncApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class CookingRecipeRepositoryImpl(
    private val cookingRecipesSyncApi: CookingRecipesSyncApi
) : CookingRecipeRepository {

    override suspend fun create(recipe: CookingRecipeItem) = withContext(Dispatchers.IO) {
        cookingRecipesSyncApi.createCookingRecipe(recipe.toSyncEntity())
    }
}