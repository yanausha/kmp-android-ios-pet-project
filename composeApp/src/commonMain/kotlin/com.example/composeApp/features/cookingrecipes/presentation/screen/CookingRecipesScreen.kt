package com.example.composeApp.features.cookingrecipes.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeApp.features.cookingrecipes.presentation.CookingRecipesViewModel
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesAction
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesEvent
import com.example.composeApp.navigations.AppScreens
import com.example.composeApp.navigations.LocalNavHost

@Composable
fun CookingRecipesScreen(
    cookingRecipesViewModel: CookingRecipesViewModel = viewModel { CookingRecipesViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by cookingRecipesViewModel.viewState().collectAsState()
    val viewAction by cookingRecipesViewModel.viewAction().collectAsState(null)

    CookingRecipesView(state = viewState) { event: CookingRecipesEvent ->
        cookingRecipesViewModel.obtainEvent(event)
    }

    when (viewAction) {
        null -> {}

        CookingRecipesAction.CreateCookingRecipe -> {
            externalNavHost.navigate(AppScreens.CookingRecipeScreen.route)
            cookingRecipesViewModel.clearAction()
        }

        CookingRecipesAction.GoBack -> {
            externalNavHost.navigate(AppScreens.MainScreen.route) {
                popUpTo(AppScreens.MainScreen.route)
            }
            cookingRecipesViewModel.clearAction()
        }
    }
}