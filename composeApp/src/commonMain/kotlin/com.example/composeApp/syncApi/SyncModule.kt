package com.example.composeApp.syncApi

import com.example.composeApp.database.AppDatabase
import com.example.composeApp.syncApiImpl.cookingRecipes.CookingRecipesSyncApiImpl
import org.koin.dsl.module

fun syncModule() = module {
    factory<CookingRecipesSyncApi> { CookingRecipesSyncApiImpl(get()) }
    factory { get<AppDatabase>().getCookingRecipeDao() }
}