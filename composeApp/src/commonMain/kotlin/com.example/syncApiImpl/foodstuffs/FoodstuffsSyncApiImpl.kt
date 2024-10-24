package com.example.syncApiImpl.foodstuffs

import com.example.syncApi.FoodstuffSyncEntity
import com.example.syncApi.FoodstuffsSyncApi
import com.example.syncApiImpl.foodstuffs.database.FoodstuffDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class FoodstuffsSyncApiImpl(
    private val foodstuffDao: FoodstuffDao
) : FoodstuffsSyncApi {
    override suspend fun getAll(): Flow<List<FoodstuffSyncEntity>> = foodstuffDao.getAll()
        .flowOn(Dispatchers.IO)
        .map { list ->
            list
                .sortedByDescending { it.insertDate }
                .map { entity -> entity.toSyncEntity() }
        }

    override suspend fun createOrUpdate(foodstuff: FoodstuffSyncEntity) =
        withContext(Dispatchers.IO) {
            foodstuffDao.insert(foodstuff.toDbEntity())
        }

    override suspend fun delete(id: Long) = withContext(Dispatchers.IO) {
        foodstuffDao.deleteById(id)
    }
}