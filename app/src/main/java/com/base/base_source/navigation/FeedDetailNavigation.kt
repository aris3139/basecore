package com.base.base_source.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.base.base_source.ui.setting.SettingsScreen

fun NavGraphBuilder.feedDetailNavigation(
    navController: androidx.navigation.NavHostController
) {

    composable<Settings> { backStackEntry ->
        val settings = backStackEntry.toRoute<Settings>()
        SettingsScreen(
            settings = settings,
            onNavigateBack = { navController.popBackStack() }
        )
    }
}