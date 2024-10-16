package com.example.composeApp.features.cookingrecipes.presentation.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesEvent
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesViewState
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.GoBackIconButton
import com.example.composeApp.ui.PlusIconButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.cookingrecipes_title

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun CookingRecipesView(
    state: CookingRecipesViewState,
    eventHandler: (CookingRecipesEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(Res.string.cookingrecipes_title),
            ) {
                GoBackIconButton {
                    eventHandler.invoke(CookingRecipesEvent.GoBackClicked)
                }
                PlusIconButton {
                    eventHandler.invoke(CookingRecipesEvent.CreateCookingRecipeClicked)
                }
            }
        }
    ) {}
}