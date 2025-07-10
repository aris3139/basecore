package com.base.base_source.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.base.base_source.ui.detail.FeedDetailScreen
import com.base.base_source.ui.home.HomeScreen
import com.base.base_source.ui.home.HomeViewModel

fun NavGraphBuilder.homeNavigation(
    navController: androidx.navigation.NavHostController
) {
    composable<Home> {
        val homeViewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(
            homeViewModel = homeViewModel,
            onNavigateToFeedDetail = { feed ->
                navController.navigate(
                    feed
                )
            },
            onNavigateToSettings = {
                navController.navigate(Settings())
            }
        )
    }


    composable<FeedDetail> { backStackEntry ->
        val feedDetail = backStackEntry.toRoute<FeedDetail>()
        FeedDetailScreen(
            feedDetail = feedDetail,
            onNavigateBack = {
                navController.popBackStack()
            }
        )
    }
}