package com.example.composeApp.features.cookingrecipe.domain

import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.syncApi.CookingRecipeSyncEntity

data class CookingRecipeItem(
    val id: Long,
    val title: String = "",
    val ingredients: List<FoodstuffItem> = emptyList(),
    val description: String = "",
    val insertDate: Long = 0L,
) {
    fun toSyncEntity() = CookingRecipeSyncEntity(
        id = id,
        title = title,
        description = description,
        insertDate = insertDate
    )
}

fun CookingRecipeSyncEntity.toItem() = CookingRecipeItem(
    id = id,
    insertDate = insertDate,
    title = title,
    description = description
)