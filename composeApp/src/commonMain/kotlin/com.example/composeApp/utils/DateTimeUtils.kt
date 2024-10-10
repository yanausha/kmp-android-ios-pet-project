package com.example.composeApp.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

internal fun getCurrentDateTimeLongFormat(): Long {
    val timeZone = TimeZone.currentSystemDefault()
    val currentMoment = Clock.System.now()
    val momentToTimeZone = currentMoment.toLocalDateTime(timeZone)
    return momentToTimeZone.toInstant(timeZone).toEpochMilliseconds()
}