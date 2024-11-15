package com.example.syncApiImpl.cookingRecipes.database

import kotlinx.coroutines.flow.Flow


interface CookingRecipeDao {
    suspend fun insert(recipe: CookingRecipeEntity)

    fun getAll(): Flow<List<CookingRecipeEntity>>

    suspend fun getById(id: String): CookingRecipeEntity
}