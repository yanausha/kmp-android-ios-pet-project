package com.example.composeApp.features.foodstuff.data

import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.composeApp.features.foodstuff.domain.FoodstuffRepository
import com.example.composeApp.features.foodstuff.domain.toItem
import com.example.syncApi.FoodstuffsSyncApi
import com.example.syncApiImpl.foodstuffs.database.FoodstuffEntity
import com.example.composeApp.utils.getCurrentDateTimeLongFormat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.random.Random

class FoodstuffRepositoryImpl(
    private val foodstuffsSyncApi: FoodstuffsSyncApi,
) : FoodstuffRepository {
    override suspend fun getAll(): Flow<List<FoodstuffItem>> =
        foodstuffsSyncApi.getAll()
            .flowOn(Dispatchers.IO)
            .map { it.map { entity -> entity.toItem() } }


    override suspend fun createItem() = withContext(Dispatchers.IO) {
        foodstuffsSyncApi.createOrUpdate(
            FoodstuffEntity(
                id = Random.nextLong(),
                insertDate = getCurrentDateTimeLongFormat(),
            ).toSyncEntity()
        )
    }

    override suspend fun updateItem(foodstuffItem: FoodstuffItem) = withContext(Dispatchers.IO) {
        foodstuffsSyncApi.createOrUpdate(foodstuffItem.toSyncEntity())
    }

    override suspend fun deleteItem(id: Long) = withContext(Dispatchers.IO) {
        foodstuffsSyncApi.delete(id)
    }
}