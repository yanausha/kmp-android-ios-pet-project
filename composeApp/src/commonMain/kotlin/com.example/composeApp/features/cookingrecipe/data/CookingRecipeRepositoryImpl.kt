package com.example.composeApp.features.cookingrecipe.data

import com.example.composeApp.features.cookingrecipe.data.database.CookingRecipeDao
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeRepository
import com.example.composeApp.utils.getCurrentDateTimeLongFormat
import kotlin.random.Random

class CookingRecipeRepositoryImpl(
    private val cookingRecipeDao: CookingRecipeDao
): CookingRecipeRepository {
    override suspend fun create(recipe: CookingRecipeItem) {
        cookingRecipeDao.insert(
            recipe = recipe.toEntity().copy(
                id = Random.nextLong(),
                insertDate = getCurrentDateTimeLongFormat()
            )
        )
    }
}