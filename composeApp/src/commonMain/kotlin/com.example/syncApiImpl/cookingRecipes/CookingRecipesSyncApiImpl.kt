package com.example.syncApiImpl.cookingRecipes

import com.example.syncApi.CookingRecipeSyncEntity
import com.example.syncApi.CookingRecipesSyncApi
import com.example.syncApiImpl.cookingRecipes.database.CookingRecipeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class CookingRecipesSyncApiImpl(
    private val cookingRecipeDataSource: CookingRecipeDataSource,
) : CookingRecipesSyncApi {
    override suspend fun getCookingRecipeList(): Flow<List<CookingRecipeSyncEntity>> =
        flow {
            emit(cookingRecipeDataSource.getAll().map { it.toSyncEntity() })
        }
            .flowOn(Dispatchers.IO)


    override suspend fun getCookingRecipeById(id: String): CookingRecipeSyncEntity =
        withContext(Dispatchers.IO) {
            cookingRecipeDataSource.getById(id).toSyncEntity()
        }

    override suspend fun createCookingRecipe(cookingRecipe: CookingRecipeSyncEntity) =
        withContext(Dispatchers.IO) {
            cookingRecipeDataSource.insert(cookingRecipe.toDbEntity())
        }
}