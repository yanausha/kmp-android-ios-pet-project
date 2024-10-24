package com.example.syncApi

import com.example.composeApp.database.AppDatabase
import com.example.syncApiImpl.cookingRecipes.CookingRecipesSyncApiImpl
import com.example.syncApiImpl.foodstuffs.FoodstuffsSyncApiImpl
import org.koin.dsl.module

fun syncModule() = module {
    factory<CookingRecipesSyncApi> { CookingRecipesSyncApiImpl(get()) }
    factory { get<AppDatabase>().getCookingRecipeDao() }

    factory { get<AppDatabase>().getFoodstuffDao() }
    factory<FoodstuffsSyncApi> { FoodstuffsSyncApiImpl(get()) }
}