package com.example.composeApp.di

import com.example.composeApp.features.cookingrecipe.cookingRecipeModule
import com.example.composeApp.features.cookingrecipes.cookingRecipesModule
import com.example.composeApp.features.foodstuff.foodstuffModule
import com.example.syncApi.syncModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

expect fun platformModule(): Module

object KoinDI {
    var di: Koin? = null

    fun setupKoin(appDeclaration: KoinAppDeclaration = {}) {
        if (di == null) di = initKoin(appDeclaration).koin
    }
}

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(
        platformModule(),
        foodstuffModule(),
        cookingRecipeModule(),
        syncModule(),
        cookingRecipesModule(),
    )
}