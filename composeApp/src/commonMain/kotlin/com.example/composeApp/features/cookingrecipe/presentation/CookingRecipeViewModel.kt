package com.example.composeApp.features.cookingrecipe.presentation

import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeAction
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeEvent
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeViewState

class CookingRecipeViewModel :
    BaseViewModel<CookingRecipeViewState, CookingRecipeAction, CookingRecipeEvent>(
        initialState = CookingRecipeViewState()
    ) {
    override fun obtainEvent(viewEvent: CookingRecipeEvent) {
        when(viewEvent) {
            CookingRecipeEvent.GoBackClicked -> goBack()
        }
    }

    private fun goBack() {
        try {
            viewAction = CookingRecipeAction.GoBack
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}