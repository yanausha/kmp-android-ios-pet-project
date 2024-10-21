package com.example.composeApp.features.cookingrecipe

import com.example.composeApp.features.cookingrecipe.data.CookingRecipeRepositoryImpl
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeInteractor
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeRepository
import org.koin.dsl.module

fun cookingRecipeModule() = module {
    single<CookingRecipeRepository> { CookingRecipeRepositoryImpl(get()) }
    factory { CookingRecipeInteractor(get()) }
}