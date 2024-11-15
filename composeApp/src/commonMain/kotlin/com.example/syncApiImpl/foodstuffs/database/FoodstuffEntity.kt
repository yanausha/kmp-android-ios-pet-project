package com.example.syncApiImpl.foodstuffs.database

import com.example.composeApp.enums.ProductUnit
import com.example.syncApi.FoodstuffSyncEntity

class FoodstuffEntity(
    val id: String,
    val name: String = "",
    val count: Long = 0,
    val unit: String = ProductUnit.PIECE.name,
    val insertDate: Long
) {
    fun toSyncEntity() = FoodstuffSyncEntity(
        id = id.toLong(),
        name = name,
        count = count.toInt(),
        unit = ProductUnit.valueOf(unit),
        insertDate = insertDate
    )
}