package com.example.composeApp.features.cookingrecipes

import com.example.composeApp.features.cookingrecipes.data.CookingRecipesRepositoryImpl
import com.example.composeApp.features.cookingrecipes.domain.CookingRecipesInteractor
import com.example.composeApp.features.cookingrecipes.domain.CookingRecipesRepository
import org.koin.dsl.module

fun cookingRecipesModule() = module {
    factory<CookingRecipesRepository> { CookingRecipesRepositoryImpl(get()) }
    factory { CookingRecipesInteractor(get()) }
}