package com.example.syncApiImpl.cookingRecipes.database

import com.example.composeApp.database.DatabaseDriverFactory
import com.example.schemas.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class CookingRecipeDataSource(driverFactory: DatabaseDriverFactory) {
    private val db = AppDatabase(driverFactory.createDriver(AppDatabase.Schema))
    private val query = db.cookingRecipeQueries

    suspend fun insert(
        cookingRecipeEntity: CookingRecipeEntity
    ) = withContext(Dispatchers.IO) {
        query.transaction {
            query.removeById(cookingRecipeEntity.id)
            query.insert(
                cookingRecipeEntity.id,
                cookingRecipeEntity.title,
                cookingRecipeEntity.insertDate,
                cookingRecipeEntity.description
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

    suspend fun getById(id: String) = withContext(Dispatchers.IO) {
        query.selectById(id, ::mapToEntity).executeAsOne()
    }
}

private fun mapToEntity(
    id: String,
    title: String?,
    insertDate: Long?,
    description: String?,
) = CookingRecipeEntity(
    id = id,
    title = title.orEmpty(),
    insertDate = insertDate ?: 0L,
    description = description.orEmpty()
)