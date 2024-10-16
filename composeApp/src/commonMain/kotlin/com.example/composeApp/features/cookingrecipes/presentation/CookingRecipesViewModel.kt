package com.example.composeApp.features.cookingrecipes.presentation

import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesAction
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesEvent
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesViewState

class CookingRecipesViewModel :
    BaseViewModel<CookingRecipesViewState, CookingRecipesAction, CookingRecipesEvent>(
        initialState = CookingRecipesViewState()
    ) {
    override fun obtainEvent(viewEvent: CookingRecipesEvent) {
        when (viewEvent) {
            CookingRecipesEvent.CreateCookingRecipeClicked -> createCookingRecipe()
            CookingRecipesEvent.GoBackClicked -> goBack()
        }
    }

    private fun goBack() {
        try {
            viewAction = CookingRecipesAction.GoBack
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun createCookingRecipe() {
        try {
            viewAction = CookingRecipesAction.CreateCookingRecipe
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}