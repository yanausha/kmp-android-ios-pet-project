package com.example.composeApp.features.cookingrecipe.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeApp.features.cookingrecipe.presentation.CookingRecipeViewModel
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeAction
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeEvent
import com.example.composeApp.navigations.AppScreens
import com.example.composeApp.navigations.LocalNavHost

@Composable
fun CookingRecipeScreen(
    cookingRecipeViewModel: CookingRecipeViewModel = viewModel { CookingRecipeViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by cookingRecipeViewModel.viewState().collectAsState()
    val viewAction by cookingRecipeViewModel.viewAction().collectAsState(null)

    CookingRecipeView(state = viewState) { event: CookingRecipeEvent ->
        cookingRecipeViewModel.obtainEvent(event)
    }

    when (viewAction) {
        null -> {}

        CookingRecipeAction.GoBack -> {
            externalNavHost.navigate(AppScreens.CookingRecipesScreen.route)
            cookingRecipeViewModel.clearAction()
        }

        CookingRecipeAction.AddIngredients -> {
            cookingRecipeViewModel.clearAction()
        }
    }
}