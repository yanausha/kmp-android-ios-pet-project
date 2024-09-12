package com.example.composeApp.navigations

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNavHost = staticCompositionLocalOf<NavHostController> { error("no default nav host") }