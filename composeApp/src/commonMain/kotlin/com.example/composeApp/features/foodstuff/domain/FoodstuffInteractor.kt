package com.example.composeApp.features.foodstuff.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class FoodstuffInteractor(
    private val repository: FoodstuffRepository
) {
    suspend fun getAll(): Flow<List<FoodstuffItem>> =
        repository.getAll()
            .flowOn(Dispatchers.IO)
            .map { items -> items.sortedByDescending { it.insertDate } }


    suspend fun createItem() = withContext(Dispatchers.IO) {
        repository.createItem()
    }

    suspend fun updateItem(foodstuffItem: FoodstuffItem) = withContext(Dispatchers.IO) {
        repository.updateItem(foodstuffItem)
    }

    suspend fun deleteItem(foodstuffItem: FoodstuffItem) = withContext(Dispatchers.IO) {
        repository.deleteItem(foodstuffItem.id)
    }
}