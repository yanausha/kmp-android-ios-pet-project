package com.example.composeApp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeApp.navigations.AppScreens
import com.example.composeApp.navigations.LocalNavHost
import com.example.composeApp.navigations.main.MainScreen
import com.example.composeApp.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        WatchEatApp()
    }
}

@Composable
internal fun WatchEatApp(
    navHostController: NavHostController = rememberNavController()
) {
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.MainScreen.route

    CompositionLocalProvider(
        LocalNavHost provides navHostController
    ) {
        NavHost(
            navController = navHostController,
            startDestination = currentScreen
        ) {
            composable(AppScreens.MainScreen.route) {
                MainScreen()
            }
        }
    }
}