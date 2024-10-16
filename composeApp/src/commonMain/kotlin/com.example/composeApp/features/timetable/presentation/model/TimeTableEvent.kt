package com.example.composeApp.features.timetable.presentation.model

sealed class TimeTableEvent {
    data object ShowCookingRecipesClicked: TimeTableEvent()
}