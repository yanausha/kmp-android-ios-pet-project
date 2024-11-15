package com.example.composeApp.database

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema

interface DatabaseDriverFactory {
    fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver
}