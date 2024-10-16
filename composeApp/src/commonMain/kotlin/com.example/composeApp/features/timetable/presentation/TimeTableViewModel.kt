package com.example.composeApp.features.timetable.presentation

import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.timetable.presentation.model.TimeTableAction
import com.example.composeApp.features.timetable.presentation.model.TimeTableEvent
import com.example.composeApp.features.timetable.presentation.model.TimeTableViewState

class TimeTableViewModel : BaseViewModel<TimeTableViewState, TimeTableAction, TimeTableEvent>(
    initialState = TimeTableViewState()
) {
    override fun obtainEvent(viewEvent: TimeTableEvent) {
        when (viewEvent) {
            TimeTableEvent.ShowCookingRecipesClicked -> showCookingRecipes()
        }
    }

    private fun showCookingRecipes() {
        try {
            viewAction = TimeTableAction.ShowCookingRecipes
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}