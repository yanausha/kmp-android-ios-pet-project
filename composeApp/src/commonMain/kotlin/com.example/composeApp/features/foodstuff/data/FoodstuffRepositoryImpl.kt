package com.example.composeApp.features.foodstuff.data

import com.example.composeApp.features.foodstuff.data.database.FoodstuffDao
import com.example.composeApp.features.foodstuff.data.database.FoodstuffEntity
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.composeApp.features.foodstuff.domain.FoodstuffRepository
import com.example.composeApp.utils.getCurrentDateTimeLongFormat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlin.random.Random

class FoodstuffRepositoryImpl(
    private val foodstuffDao: FoodstuffDao,
) : FoodstuffRepository {
    override suspend fun getAll(): Flow<List<FoodstuffItem>> =
        foodstuffDao.getAll()
            .flowOn(Dispatchers.IO)
            .map { it.map { entity -> entity.toItem() } }

    override suspend fun createItem() {
        foodstuffDao.insert(
            FoodstuffEntity(
                id = Random.nextLong(),
                insertDate = getCurrentDateTimeLongFormat(),
            )
        )
    }

    override suspend fun updateItem(foodstuffItem: FoodstuffItem) {
        foodstuffDao.insert(foodstuffItem.toDbEntity())
    }

    override suspend fun deleteItem(id: Long) {
        foodstuffDao.deleteById(id)
    }
}