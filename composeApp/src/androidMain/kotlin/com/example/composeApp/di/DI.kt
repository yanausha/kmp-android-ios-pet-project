package com.example.composeApp.di

import com.example.composeApp.database.AndroidDatabaseDriverFactory
import com.example.composeApp.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }
}