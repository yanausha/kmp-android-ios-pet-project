package com.example.composeApp.features.foodstuff.domain

import com.example.composeApp.features.foodstuff.database.FoodstuffEntity

data class FoodstuffItem(
    val id: Long,
    val name: String?,
    val count: Int?,
) {
    fun toDbEntity() = FoodstuffEntity(
        id = this.id,
        name = this.name,
        count = this.count
    )
}

