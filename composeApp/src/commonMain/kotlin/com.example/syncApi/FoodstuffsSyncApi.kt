package com.example.syncApi

import kotlinx.coroutines.flow.Flow

interface FoodstuffsSyncApi {
    suspend fun getAll(): Flow<List<FoodstuffSyncEntity>>
    suspend fun createOrUpdate(foodstuff: FoodstuffSyncEntity)
    suspend fun delete(id: Long)
}