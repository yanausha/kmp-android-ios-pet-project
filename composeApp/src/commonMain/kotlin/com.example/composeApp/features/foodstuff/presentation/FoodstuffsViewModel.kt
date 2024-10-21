package com.example.composeApp.features.foodstuff.presentation

import androidx.lifecycle.viewModelScope
import com.example.composeApp.base.BaseViewModel
import com.example.composeApp.features.foodstuff.domain.FoodstuffInteractor
import com.example.composeApp.features.foodstuff.domain.FoodstuffItem
import com.example.composeApp.features.foodstuff.presentation.model.FoodstuffsAction
import com.example.composeApp.features.foodstuff.presentation.model.FoodstuffsEvent
import com.example.composeApp.features.foodstuff.presentation.model.FoodstuffsViewState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FoodstuffsViewModel :
    BaseViewModel<FoodstuffsViewState, FoodstuffsAction, FoodstuffsEvent>(initialState = FoodstuffsViewState()),
    KoinComponent {

    private val interactor: FoodstuffInteractor by inject()

    init {
        updateList()
    }

    override fun obtainEvent(viewEvent: FoodstuffsEvent) {
        when (viewEvent) {
            is FoodstuffsEvent.OnFoodstuffDelete -> {
                deleteItem(viewEvent.foodstuff)
                updateList()
            }

            is FoodstuffsEvent.OnFoodstuffUpdate -> {
                updateItem(viewEvent.foodstuff)
                updateList()
            }

            FoodstuffsEvent.CreateItemClicked -> {
                createItem()
                updateList()
            }
        }
    }

    private fun updateList() {
        viewModelScope.launch {
            interactor.getAll()
                .catch { it.printStackTrace() }
                .collect { list: List<FoodstuffItem> ->
                    viewState = viewState.copy(foodstuffs = list)
                }
        }
    }

    private fun createItem() {
        viewModelScope.launch {
            try {
                interactor.createItem()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun updateItem(foodstuffItem: FoodstuffItem) {
        viewModelScope.launch {
            try {
                interactor.updateItem(foodstuffItem)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun deleteItem(foodstuffItem: FoodstuffItem) {
        viewModelScope.launch {
            try {
                interactor.deleteItem(foodstuffItem)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}