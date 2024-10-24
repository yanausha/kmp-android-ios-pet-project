package com.example.syncApiImpl.foodstuffs.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composeApp.enums.ProductUnit
import com.example.syncApi.FoodstuffSyncEntity

@Entity
class FoodstuffEntity(
    @PrimaryKey val id: Long,
    val name: String = "",
    val count: Int = 0,
    val unit: String = ProductUnit.PIECE.name,
    val insertDate: Long
) {
    fun toSyncEntity() = FoodstuffSyncEntity(
        id = id,
        name = name,
        count = count,
        unit = ProductUnit.valueOf(unit),
        insertDate = insertDate
    )
}