package com.example.composeApp.features.foodstuff.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composeApp.enums.ProductUnit
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem

@Entity
class FoodstuffEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String = "",
    val count: Int = 0,
    val unit: String = ProductUnit.PIECE.name,
    val insertDate: Long
) {
    fun toItem() = FoodstuffItem(
        id = this.id,
        name = this.name,
        count = this.count,
        unit = ProductUnit.valueOf(this.unit),
        insertDate = this.insertDate
    )
}