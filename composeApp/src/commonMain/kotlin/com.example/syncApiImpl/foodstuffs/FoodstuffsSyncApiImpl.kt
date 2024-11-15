package com.example.syncApiImpl.foodstuffs

import com.example.syncApi.FoodstuffSyncEntity
import com.example.syncApi.FoodstuffsSyncApi
import com.example.syncApiImpl.foodstuffs.database.FoodstuffDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class FoodstuffsSyncApiImpl(
    private val foodstuffDataSource: FoodstuffDataSource
) : FoodstuffsSyncApi {

    override suspend fun getAll(): Flow<List<FoodstuffSyncEntity>> = flow {
        emit(
            foodstuffDataSource.getAll().map { it.toSyncEntity() }
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun createOrUpdate(foodstuff: FoodstuffSyncEntity) =
        withContext(Dispatchers.IO) {
            foodstuffDataSource.insert(foodstuff.toDbEntity())
        }

    override suspend fun delete(id: Long) = withContext(Dispatchers.IO) {
        foodstuffDataSource.deleteById(id.toString())
    }
}