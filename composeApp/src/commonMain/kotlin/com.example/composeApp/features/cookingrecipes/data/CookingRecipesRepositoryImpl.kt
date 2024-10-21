package com.example.composeApp.features.cookingrecipes.data

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipes.domain.CookingRecipesRepository
import com.example.composeApp.syncApi.CookingRecipesSyncApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class CookingRecipesRepositoryImpl(
    private val cookingRecipesSyncApi: CookingRecipesSyncApi
) : CookingRecipesRepository {

    override suspend fun getAll(): Flow<List<CookingRecipeItem>> =
        cookingRecipesSyncApi.getCookingRecipeList()
            .flowOn(Dispatchers.IO)
            .map { list ->
                list.map { it.toItem() }
            }
}