package com.example.composeApp.features.foodstuff.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeApp.features.foodstuff.presentation.FoodstuffsViewModel
import com.example.composeApp.navigations.LocalNavHost
import com.example.composeApp.features.foodstuff.presentation.model.FoodstuffsEvent

@Composable
fun FoodstuffsScreen(
    foodstuffsViewModel: FoodstuffsViewModel = viewModel { FoodstuffsViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by foodstuffsViewModel.viewState().collectAsState()
    val viewAction by foodstuffsViewModel.viewAction().collectAsState(null)

    FoodstuffsView(state = viewState) { event: FoodstuffsEvent ->
        foodstuffsViewModel.obtainEvent(event)
    }
}