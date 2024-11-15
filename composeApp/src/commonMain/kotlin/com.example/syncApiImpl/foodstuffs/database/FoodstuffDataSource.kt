package com.example.syncApiImpl.foodstuffs.database

import com.example.composeApp.database.DatabaseDriverFactory
import com.example.composeApp.enums.ProductUnit
import com.example.schemas.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class FoodstuffDataSource(driverFactory: DatabaseDriverFactory) {
    private val db = AppDatabase(driverFactory.createDriver(AppDatabase.Schema))
    private val query = db.foodstuffQueries

    suspend fun insert(
        foodstuffEntity: FoodstuffEntity
    ) = withContext(Dispatchers.IO) {
        query.transaction {
            query.removeById(foodstuffEntity.id)
            query.insert(
                foodstuffEntity.id,
                foodstuffEntity.name,
                foodstuffEntity.count,
                foodstuffEntity.unit,
                foodstuffEntity.insertDate
            )
        }
    }

    suspend fun getAll() =
        withContext(Dispatchers.IO) { query.selectAll(::mapToEntity).executeAsList() }

    suspend fun deleteById(id: String) = withContext(Dispatchers.IO) {
        query.transaction {
            query.removeById(id)
        }
    }
}

private fun mapToEntity(
    id: String,
    name: String?,
    count: Long?,
    unit: String?,
    insertDate: Long?
) = FoodstuffEntity(
    id = id,
    name = name.orEmpty(),
    count = count ?: 0L,
    unit = unit ?: ProductUnit.PIECE.name,
    insertDate = insertDate ?: 0L,
)