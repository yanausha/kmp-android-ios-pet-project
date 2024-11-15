package com.example.syncApiImpl.cookingRecipes.database

import com.example.syncApi.CookingRecipeSyncEntity

class CookingRecipeEntity(
    val id: String,
    val title: String,
    val insertDate: Long = 0L,
    val description: String,
) {
    fun toSyncEntity() = CookingRecipeSyncEntity(
        id = id.toLong(),
        insertDate = insertDate,
        title = title,
        description = description
    )
}