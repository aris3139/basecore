package com.base.base_source.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.base.base_source.ui.splash.SplashScreen

fun NavGraphBuilder.splashNavigation(
    navController: NavHostController
) {

    composable<Splash> { backStackEntry ->
        backStackEntry.toRoute<Splash>()
        SplashScreen(
            navigateToHome = {
                navController.navigate(Home)
            }
        )
    }
}