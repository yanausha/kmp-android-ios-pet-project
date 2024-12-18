package com.example.composeApp.database

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver =
        AndroidSqliteDriver(schema.synchronous(), context, "watcheat.db")
}