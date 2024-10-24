package com.example.composeApp.features.foodstuff

import com.example.composeApp.features.foodstuff.data.FoodstuffRepositoryImpl
import com.example.composeApp.features.foodstuff.domain.FoodstuffInteractor
import com.example.composeApp.features.foodstuff.domain.FoodstuffRepository
import org.koin.dsl.module

fun foodstuffModule() = module {
    single<FoodstuffRepository> { FoodstuffRepositoryImpl(get()) }
    factory { FoodstuffInteractor(get()) }
}