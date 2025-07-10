package com.base.base_source.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.base.base_source.ui.feedDetail.FeedDetailScreen
import com.base.base_source.ui.home.HomeScreen

fun NavGraphBuilder.homeNavigation(
    navController: androidx.navigation.NavHostController
) {
    composable<Home> {
        HomeScreen(
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

//    composable<Settings> { backStackEntry ->
//        val feedDetail = backStackEntry.toRoute<FeedDetail>()
//        FeedDetailScreen(
//            feedDetail = feedDetail,
//            onNavigateBack = {
//                navController.popBackStack()
//            }
//        )
//    }
}