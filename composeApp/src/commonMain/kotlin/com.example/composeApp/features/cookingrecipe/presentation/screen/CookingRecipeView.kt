package com.example.composeApp.features.cookingrecipe.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeEvent
import com.example.composeApp.features.cookingrecipe.presentation.model.CookingRecipeViewState
import com.example.composeApp.theme.WatchEatTheme
import com.example.composeApp.ui.BaseButton
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.GoBackIconButton
import com.example.composeApp.ui.InputText
import com.example.composeApp.ui.MediumSpacer
import com.example.composeApp.ui.NotColorSpacer
import com.example.composeApp.ui.PlusIconButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.cookingrecipe_title
import watcheat.composeapp.generated.resources.create
import watcheat.composeapp.generated.resources.hint_description
import watcheat.composeapp.generated.resources.hint_name
import watcheat.composeapp.generated.resources.ingredients

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
        },
        bottomBar = {
            BaseButton(
                title = stringResource(Res.string.create),
            ) {
                eventHandler.invoke(CookingRecipeEvent.OnCreateClicked)
            }
        }
    ) { paddingValues ->
        Content(
            paddingValues = paddingValues,
            recipe = state.recipe,
            onRecipeUpdateClicked = { recipe ->
                eventHandler.invoke(CookingRecipeEvent.OnRecipeUpdated(recipe))
            },
            onAddIngredientsActionClicked = {
                eventHandler.invoke(CookingRecipeEvent.AddIngredientsClicked)
            }
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun Content(
    paddingValues: PaddingValues,
    recipe: CookingRecipeItem,
    onRecipeUpdateClicked: (CookingRecipeItem) -> Unit,
    onAddIngredientsActionClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues)
    ) {
        InputText(
            value = recipe.title,
            hint = stringResource(Res.string.hint_name)
        ) { naming ->
            onRecipeUpdateClicked(recipe.copy(title = naming))
        }
        NotColorSpacer()
        IngredientActions {
            onAddIngredientsActionClicked()
        }
        MediumSpacer()
        InputText(
            value = recipe.description,
            hint = stringResource(Res.string.hint_description)
        ) { description ->
            onRecipeUpdateClicked(recipe.copy(description = description))
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun IngredientActions(
    onIngredientActionClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 18.dp),
            text = stringResource(Res.string.ingredients),
            style = TextStyle(
                color = WatchEatTheme.colors.tomatoElement,
                fontWeight = FontWeight.Bold,
            ),
        )
        PlusIconButton(
            color = WatchEatTheme.colors.tomatoElement
        ) {
            onIngredientActionClicked()
        }
    }
}