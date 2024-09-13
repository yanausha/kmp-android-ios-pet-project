package com.example.composeApp.features.timetable

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.timetable.model.TimeTableEvent
import com.example.composeApp.features.timetable.model.TimeTableViewState
import com.example.composeApp.ui.BaseToolbar

@Composable
internal fun TimeTableView(
    state: TimeTableViewState,
    eventHandler: (TimeTableEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                "Дневник питания"
            )
        }
    ) {

    }
}