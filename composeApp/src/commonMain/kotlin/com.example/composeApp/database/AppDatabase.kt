package com.example.composeApp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeApp.syncApiImpl.cookingRecipes.database.CookingRecipeDao
import com.example.composeApp.syncApiImpl.cookingRecipes.database.CookingRecipeEntity
import com.example.composeApp.features.foodstuff.data.database.FoodstuffDao
import com.example.composeApp.features.foodstuff.data.database.FoodstuffEntity

@Database(
    entities = [
        FoodstuffEntity::class,
        CookingRecipeEntity::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFoodstuffDao(): FoodstuffDao
    abstract fun getCookingRecipeDao(): CookingRecipeDao
}

internal const val dbFileName = "watcheat.db"