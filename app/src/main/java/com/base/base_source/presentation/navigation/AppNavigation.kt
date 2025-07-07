package com.base.base_source.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.base.base_source.presentation.home.HomeComposeScreen
import com.base.base_source.presentation.splash.ComposeSplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            ComposeSplashScreen(
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeComposeScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    // Add more screens as needed
}