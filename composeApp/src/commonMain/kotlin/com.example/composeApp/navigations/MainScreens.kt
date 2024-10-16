package com.example.composeApp.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainScreens(val route: String, val icon: ImageVector) {
    ShoppingList("shoppinglist", Icons.Filled.ShoppingCart),
    TimeTable("timetable", Icons.AutoMirrored.Filled.List),
    Foodstuffs("foodstuffs", Icons.Filled.Home)
}

enum class AppScreens(val route: String) {
    MainScreen("main"),
    CookingRecipesScreen("cookingrecipes"),
    CookingRecipeScreen("cookingrecipe"),
}