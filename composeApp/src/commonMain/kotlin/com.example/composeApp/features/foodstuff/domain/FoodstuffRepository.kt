package com.example.composeApp.features.foodstuff.domain

import kotlinx.coroutines.flow.Flow

interface FoodstuffRepository {
    suspend fun getAll(): Flow<List<FoodstuffItem>>
    suspend fun createItem()
    suspend fun updateItem(foodstuffItem: FoodstuffItem)
    suspend fun deleteItem(id: Long)
}