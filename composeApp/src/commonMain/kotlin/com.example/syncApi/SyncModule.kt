package com.example.syncApi

import com.example.syncApiImpl.cookingRecipes.CookingRecipesSyncApiImpl
import com.example.syncApiImpl.cookingRecipes.database.CookingRecipeDataSource
import com.example.syncApiImpl.foodstuffs.FoodstuffsSyncApiImpl
import com.example.syncApiImpl.foodstuffs.database.FoodstuffDataSource
import org.koin.dsl.module

fun syncModule() = module {
    factory<CookingRecipesSyncApi> { CookingRecipesSyncApiImpl(get()) }
    factory<FoodstuffsSyncApi> { FoodstuffsSyncApiImpl(get()) }

    single<FoodstuffDataSource> { FoodstuffDataSource(get()) }
    single<CookingRecipeDataSource> { CookingRecipeDataSource(get()) }
}