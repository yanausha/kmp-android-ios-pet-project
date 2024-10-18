package com.example.composeApp.features.cookingrecipe.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CookingRecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: CookingRecipeEntity)
}