package com.base.base_source.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        splashNavigation(navController = navController)
        homeNavigation(navController = navController)
        feedDetailNavigation(navController = navController)
    }
}
