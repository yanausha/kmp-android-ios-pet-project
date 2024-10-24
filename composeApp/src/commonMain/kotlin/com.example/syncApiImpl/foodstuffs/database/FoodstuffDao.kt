package com.example.syncApiImpl.foodstuffs.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodstuffDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(foodstuffList: List<FoodstuffEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(foodstuff: FoodstuffEntity)

    @Query("SELECT * FROM FoodstuffEntity")
    fun getAll(): Flow<List<FoodstuffEntity>>

    @Query("DELETE FROM FoodstuffEntity WHERE FoodstuffEntity.id = :id")
    suspend fun deleteById(id: Long)
}