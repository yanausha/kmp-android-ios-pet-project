package com.example.composeApp.features.foodstuff.domain

import com.example.composeApp.enums.ProductUnit
import com.example.composeApp.features.foodstuff.data.database.FoodstuffEntity

data class FoodstuffItem(
    val id: Long,
    val name: String = "",
    val count: Int = 0,
    val unit: ProductUnit = ProductUnit.PIECE,
    val insertDate: Long
) {
    fun toDbEntity() = FoodstuffEntity(
        id = this.id,
        name = this.name,
        count = this.count,
        unit = this.unit.name,
        insertDate = this.insertDate
    )
}

