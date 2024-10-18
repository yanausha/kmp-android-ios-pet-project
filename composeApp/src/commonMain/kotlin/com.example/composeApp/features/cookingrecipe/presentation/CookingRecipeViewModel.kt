package com.example.composeApp.features.cookingrecipe.presentation

import androidx.lifecycle.viewModelScope
import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeInteractor
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeAction
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeEvent
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeViewState
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CookingRecipeViewModel :
    BaseViewModel<CookingRecipeViewState, CookingRecipeAction, CookingRecipeEvent>(
        initialState = CookingRecipeViewState()
    ), KoinComponent {

    private val interactor: CookingRecipeInteractor by inject()

    override fun obtainEvent(viewEvent: CookingRecipeEvent) {
        when (viewEvent) {
            CookingRecipeEvent.GoBackClicked -> goBack()

            is CookingRecipeEvent.OnRecipeUpdated -> updateRecipe(viewEvent.recipe)

            CookingRecipeEvent.AddIngredientsClicked -> addIngredients()

            CookingRecipeEvent.OnCreateClicked -> create()
        }
    }

    private fun create() {
        viewModelScope.launch {
            try {
                interactor.create(viewState.recipe)
                viewAction = CookingRecipeAction.GoBack
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    private fun addIngredients() {
        viewModelScope.launch {
            try {
                viewAction = CookingRecipeAction.AddIngredients
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    private fun updateRecipe(recipe: CookingRecipeItem) {
        viewModelScope.launch {
            try {
                viewState = viewState.copy(recipe = recipe)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    private fun goBack() {
        viewModelScope.launch {
            try {
                viewAction = CookingRecipeAction.GoBack
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}