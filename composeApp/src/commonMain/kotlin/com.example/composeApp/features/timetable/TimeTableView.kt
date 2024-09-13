package com.example.composeApp.features.timetable

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.timetable.model.TimeTableEvent
import com.example.composeApp.features.timetable.model.TimeTableViewState
import com.example.composeApp.ui.BaseToolbar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.timetable

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun TimeTableView(
    state: TimeTableViewState,
    eventHandler: (TimeTableEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(Res.string.timetable)
            )
        }
    ) {

    }
}