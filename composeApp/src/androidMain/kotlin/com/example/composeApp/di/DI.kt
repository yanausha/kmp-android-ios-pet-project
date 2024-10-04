package com.example.composeApp.di

import com.example.composeApp.database.AppDatabase
import com.example.composeApp.database.getDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single<AppDatabase> { getDatabase(androidContext()) }
}