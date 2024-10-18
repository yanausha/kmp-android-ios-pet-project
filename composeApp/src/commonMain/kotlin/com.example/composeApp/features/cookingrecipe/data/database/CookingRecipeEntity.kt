package com.example.composeApp.features.cookingrecipe.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem

@Entity
data class CookingRecipeEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val insertDate: Long = 0L,
    val description: String,
) {
    fun toItem() = CookingRecipeItem(
        id = id,
        title = title,
        description = description
    )
}