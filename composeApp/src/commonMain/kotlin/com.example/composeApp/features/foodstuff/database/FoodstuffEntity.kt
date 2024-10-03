package com.example.composeApp.features.foodstuff.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composeApp.enums.ProductUnit
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem

@Entity
class FoodstuffEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String?,
    val count: Int?,
    val unit: String = ProductUnit.PIECE.name
) {
    fun toItem() = FoodstuffItem(
        id = this.id,
        name = this.name,
        count = this.count,
        unit = ProductUnit.valueOf(this.unit)
    )
}