package com.example.composeApp.database

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.native.NativeSqliteDriver

class IOSDatabaseDriverFactory: DatabaseDriverFactory {
    override fun createDriver(
        schema: SqlSchema<QueryResult.AsyncValue<Unit>>
    ): SqlDriver = NativeSqliteDriver(schema.synchronous(), "watcheat.db")
}