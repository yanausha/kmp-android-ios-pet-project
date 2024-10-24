package com.example.syncApi

import com.example.composeApp.enums.ProductUnit
import com.example.syncApiImpl.foodstuffs.database.FoodstuffEntity

class FoodstuffSyncEntity (
    val id: Long,
    val name: String,
    val count: Int,
    val unit: ProductUnit,
    val insertDate: Long
) {
    fun toDbEntity() = FoodstuffEntity(
        id = id,
        name = name,
        count = count,
        unit = unit.name,
        insertDate = insertDate
    )
}