package com.example.composeApp.features.cookingrecipe.presentation.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeEvent
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeViewState
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.GoBackIconButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.cookingrecipe_title

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun CookingRecipeView(
    state: CookingRecipeViewState,
    eventHandler: (CookingRecipeEvent) -> Unit
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(Res.string.cookingrecipe_title),
            ) {
                GoBackIconButton {
                    eventHandler.invoke(CookingRecipeEvent.GoBackClicked)
                }
            }
        }
    ) {}
}