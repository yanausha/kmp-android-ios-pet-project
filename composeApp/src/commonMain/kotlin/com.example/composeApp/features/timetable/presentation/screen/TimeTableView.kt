package com.example.composeApp.features.timetable.presentation.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.timetable.presentation.model.TimeTableEvent
import com.example.composeApp.features.timetable.presentation.model.TimeTableViewState
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.PlusIconButton
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
                title = stringResource(Res.string.timetable),
            ) {
                PlusIconButton {
                    eventHandler.invoke(TimeTableEvent.ShowCookingRecipesClicked)
                }
            }
        }
    ) {}
}