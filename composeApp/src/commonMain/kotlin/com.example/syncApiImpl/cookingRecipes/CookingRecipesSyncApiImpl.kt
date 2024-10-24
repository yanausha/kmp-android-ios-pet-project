package com.example.syncApiImpl.cookingRecipes

import com.example.syncApiImpl.cookingRecipes.database.CookingRecipeDao
import com.example.syncApi.CookingRecipeSyncEntity
import com.example.syncApi.CookingRecipesSyncApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CookingRecipesSyncApiImpl(
    private val cookingRecipeDao: CookingRecipeDao,
) : CookingRecipesSyncApi {
    override suspend fun getCookingRecipeList(): Flow<List<CookingRecipeSyncEntity>> =
        cookingRecipeDao.getAll()
            .flowOn(Dispatchers.IO)
            .map { list ->
                list
                    .sortedByDescending { it.insertDate }
                    .map { it.toSyncEntity() }
            }

    override suspend fun getCookingRecipeById(id: String): CookingRecipeSyncEntity =
        withContext(Dispatchers.IO) {
            cookingRecipeDao.getById(id).toSyncEntity()
        }

    override suspend fun createCookingRecipe(cookingRecipe: CookingRecipeSyncEntity) =
        withContext(Dispatchers.IO) {
            cookingRecipeDao.insert(cookingRecipe.toDbEntity())
        }
}