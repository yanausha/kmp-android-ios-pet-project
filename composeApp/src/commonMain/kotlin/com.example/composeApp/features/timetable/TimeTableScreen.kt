package com.example.composeApp.features.timetable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeApp.features.timetable.model.TimeTableEvent
import com.example.composeApp.navigations.LocalNavHost

@Composable
internal fun TimeTableScreen(
    timeTableViewModel: TimeTableViewModel = viewModel { TimeTableViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by timeTableViewModel.viewState().collectAsState()
    val viewAction by timeTableViewModel.viewAction().collectAsState(null)

    TimeTableView(state = viewState) { event: TimeTableEvent ->
        timeTableViewModel.obtainEvent(event)
    }
}