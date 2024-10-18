package com.example.composeApp.features.cookingrecipe.domain

import com.example.composeApp.features.cookingrecipe.data.database.CookingRecipeEntity
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem

data class CookingRecipeItem(
    val id: Long,
    val title: String = "",
    val ingredients: List<FoodstuffItem> = emptyList(),
    val description: String = "",
) {
    fun toEntity() = CookingRecipeEntity(
        id = id,
        title = title,
        description = description,
    )
}