package com.base.base_source.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.base.base_source.presentation.home.HomeComposeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeComposeScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    // Add more screens as needed
}