package com.example.composeApp.features.cookingrecipe

import com.example.composeApp.database.AppDatabase
import com.example.composeApp.features.cookingrecipe.data.CookingRecipeRepositoryImpl
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeInteractor
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeRepository
import org.koin.dsl.module

fun cookingRecipeModule() = module {
    factory { get<AppDatabase>().getCookingRecipeDao() }
    single<CookingRecipeRepository> { CookingRecipeRepositoryImpl(get()) }
    factory { CookingRecipeInteractor(get()) }
}