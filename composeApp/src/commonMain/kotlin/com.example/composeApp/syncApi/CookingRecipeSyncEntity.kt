package com.example.composeApp.syncApi

import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.syncApiImpl.cookingRecipes.database.CookingRecipeEntity

class CookingRecipeSyncEntity(
    val id: Long,
    val insertDate: Long,
    val title: String,
    val description: String,
) {
    fun toEntity() = CookingRecipeEntity(
        id = id,
        insertDate = insertDate,
        title = title,
        description = description
    )

    fun toItem() = CookingRecipeItem(
        id = id,
        insertDate = insertDate,
        title = title,
        description = description
    )
}