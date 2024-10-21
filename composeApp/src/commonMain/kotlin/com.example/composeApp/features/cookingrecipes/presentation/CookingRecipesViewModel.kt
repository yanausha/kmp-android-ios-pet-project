package com.example.composeApp.features.cookingrecipes.presentation

import androidx.lifecycle.viewModelScope
import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.cookingrecipes.domain.CookingRecipesInteractor
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesAction
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesEvent
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesViewState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CookingRecipesViewModel :
    BaseViewModel<CookingRecipesViewState, CookingRecipesAction, CookingRecipesEvent>(
        initialState = CookingRecipesViewState()
    ), KoinComponent {
    private val interactor: CookingRecipesInteractor by inject()

    init {
        updateList()
    }

    override fun obtainEvent(viewEvent: CookingRecipesEvent) {
        when (viewEvent) {
            CookingRecipesEvent.CreateCookingRecipeClicked -> createCookingRecipe()
            CookingRecipesEvent.GoBackClicked -> goBack()
        }
    }

    private fun goBack() = viewModelScope.launch {
        try {
            viewAction = CookingRecipesAction.GoBack
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun createCookingRecipe() = viewModelScope.launch {
        try {
            viewAction = CookingRecipesAction.CreateCookingRecipe
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateList() = viewModelScope.launch {
        interactor.getCookingRecipes().catch { it.printStackTrace() }.collect {
            viewState = viewState.copy(cookingRecipes = it)
        }
    }
}