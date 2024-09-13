package com.example.composeApp.features.timetable

import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.timetable.model.TimeTableAction
import com.example.composeApp.features.timetable.model.TimeTableEvent
import com.example.composeApp.features.timetable.model.TimeTableViewState

class TimeTableViewModel : BaseViewModel<TimeTableViewState, TimeTableAction, TimeTableEvent>(
    initialState = TimeTableViewState()
) {
    override fun obtainEvent(viewEvent: TimeTableEvent) {
        when (viewEvent) {

        }
    }
}