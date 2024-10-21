package com.example.composeApp.syncApiImpl.cookingRecipes

import com.example.composeApp.syncApiImpl.cookingRecipes.database.CookingRecipeDao
import com.example.composeApp.syncApi.CookingRecipeSyncEntity
import com.example.composeApp.syncApi.CookingRecipesSyncApi
import com.example.composeApp.utils.getCurrentDateTimeLongFormat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.random.Random

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

    override suspend fun createCookingRecipe(cookingRecipe: CookingRecipeSyncEntity) {
        cookingRecipeDao.insert(
            cookingRecipe.toEntity().copy(
                id = Random.nextLong(),
                insertDate = getCurrentDateTimeLongFormat()
            )
        )
    }
}