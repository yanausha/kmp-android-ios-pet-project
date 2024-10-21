package com.example.composeApp.features.cookingrecipe.domain

import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.composeApp.syncApi.CookingRecipeSyncEntity

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