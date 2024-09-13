package com.example.composeApp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeApp.features.foodstuff.database.FoodstuffDao
import com.example.composeApp.features.foodstuff.database.FoodstuffEntity

@Database(entities = [FoodstuffEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getFoodstuffDao(): FoodstuffDao
}

internal const val dbFileName = "watcheat.db"