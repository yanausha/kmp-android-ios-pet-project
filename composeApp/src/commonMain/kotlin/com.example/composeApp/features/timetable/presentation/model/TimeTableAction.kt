package com.example.composeApp.features.timetable.presentation.model

sealed class TimeTableAction {
    data object ShowCookingRecipes: TimeTableAction()
}