package com.example.syncApi

import com.example.syncApiImpl.cookingRecipes.database.CookingRecipeEntity

class CookingRecipeSyncEntity(
    val id: Long,
    val insertDate: Long,
    val title: String,
    val description: String,
) {
    fun toDbEntity() = CookingRecipeEntity(
        id = id.toString(),
        insertDate = insertDate,
        title = title,
        description = description
    )
}