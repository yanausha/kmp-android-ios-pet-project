package com.example.composeApp.features.cookingrecipes.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeApp.features.cookingrecipe.domain.CookingRecipeItem
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesEvent
import com.example.composeApp.features.cookingrecipes.presentation.model.CookingRecipesViewState
import com.example.composeApp.theme.WatchEatTheme
import com.example.composeApp.ui.BaseToolbar
import com.example.composeApp.ui.EcruColor20Spacer
import com.example.composeApp.ui.GoBackIconButton
import com.example.composeApp.ui.PlusIconButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.cookingrecipe_not_title
import watcheat.composeapp.generated.resources.cookingrecipes_title
import watcheat.composeapp.generated.resources.ingredients_is_empty

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
    ) { paddingValues ->
        Content(
            paddingValues = paddingValues,
            cookingRecipes = state.cookingRecipes,
            onItemClicked = {
                eventHandler.invoke(CookingRecipesEvent.CreateCookingRecipeClicked)
            }
        )
    }
}

@Composable
private fun Content(
    paddingValues: PaddingValues,
    cookingRecipes: List<CookingRecipeItem>,
    onItemClicked: (CookingRecipeItem) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues
    ) {
        items(cookingRecipes) { item: CookingRecipeItem ->
            key(item.id) {
                CookingRecipeItem(item) { onItemClicked(it) }
                EcruColor20Spacer()
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CookingRecipeItem(
    item: CookingRecipeItem,
    onItemClicked: (CookingRecipeItem) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClicked(item) }
    ) {
        Column {
            Text(
                modifier = Modifier.padding(bottom = 2.dp),
                text = item.title.ifEmpty { stringResource(Res.string.cookingrecipe_not_title) },
                style = TextStyle(
                    color = WatchEatTheme.colors.darkBrowmOliveText,
                    fontWeight = FontWeight.Bold,
                ),
            )
            Text(
                text = item.ingredients
                    .joinToString(", ") { it.name }
                    .ifEmpty { stringResource(Res.string.ingredients_is_empty) },
                style = TextStyle(
                    color = WatchEatTheme.colors.ecruElement,
                ),
                maxLines = 1
            )
        }
    }
}