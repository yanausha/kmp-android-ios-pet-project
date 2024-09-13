package com.example.composeApp.navigations.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeApp.features.foodstuff.FoodstuffsScreen
import com.example.composeApp.features.shoppinglist.ShoppingListScreen
import com.example.composeApp.features.timetable.TimeTableScreen
import com.example.composeApp.navigations.MainScreens
import com.example.composeApp.theme.WatchEatTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController,
            modifier = Modifier.padding(bottom = 48.dp).fillMaxHeight(),
            startDestination = MainScreens.ShoppingList.route
        ) {
            composable(MainScreens.ShoppingList.route) { ShoppingListScreen() }
            composable(MainScreens.TimeTable.route) { TimeTableScreen() }
            composable(MainScreens.Foodstuffs.route) { FoodstuffsScreen() }
        }

        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().height(48.dp),
            backgroundColor = WatchEatTheme.colors.quartzBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = null,
                            tint = WatchEatTheme.colors.whiteText
                        )
                    },
                    onClick = { navController.navigate(screen.route) },
                )
            }
        }
    }
}