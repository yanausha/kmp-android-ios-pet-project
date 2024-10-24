package com.example.syncApiImpl.cookingRecipes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CookingRecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: CookingRecipeEntity)

    @Query("SELECT * FROM CookingRecipeEntity")
    fun getAll(): Flow<List<CookingRecipeEntity>>

    @Query("SELECT * FROM CookingRecipeEntity WHERE CookingRecipeEntity.id=:id")
    suspend fun getById(id: String): CookingRecipeEntity
}