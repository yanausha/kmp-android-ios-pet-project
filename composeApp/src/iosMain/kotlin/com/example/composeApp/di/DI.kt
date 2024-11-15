package com.example.composeApp.di

import com.example.composeApp.database.IOSDatabaseDriverFactory
import com.example.composeApp.database.DatabaseDriverFactory
import org.koin.dsl.module

actual fun platformModule() = module {
    single<DatabaseDriverFactory> { IOSDatabaseDriverFactory() }
}