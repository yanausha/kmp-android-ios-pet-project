package com.example.syncApiImpl.cookingRecipes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.syncApi.CookingRecipeSyncEntity

@Entity
class CookingRecipeEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val insertDate: Long = 0L,
    val description: String,
) {
    fun toSyncEntity() = CookingRecipeSyncEntity(
        id = id,
        insertDate = insertDate,
        title = title,
        description = description
    )
}