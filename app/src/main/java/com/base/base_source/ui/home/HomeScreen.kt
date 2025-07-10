package com.base.base_source.ui.home

import BottomNavType
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.base.base_source.extentions.CustomSpacer
import com.base.base_source.navigation.FeedDetail
import com.base.base_source.ui.home.component.Header
import com.base.base_source.ui.home.component.feed.listFeed
import com.base.base_source.ui.home.component.story.ListStory
import com.base.base_source.ui.navigation.BottomNavigation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onNavigateToFeedDetail: (FeedDetail) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    // region common
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    // endregion
    // region handle navigation
    val selectedTab = remember { mutableStateOf<BottomNavType>(BottomNavType.Home) }
    //endregion

    Scaffold(
        topBar = {
            Header(
                modifier = Modifier.padding(
                    top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
                )
            )
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                selectedTab = selectedTab.value,
                onTabSelected = { selectedTab.value = it }
            )
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                item {
                    CustomSpacer(
                        height = 1.dp,
                        color = Color.LightGray
                    )
                }
                item {
                    ListStory(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
                item {
                    CustomSpacer(
                        height = 1.dp,
                        color = Color.LightGray
                    )
                }
                listFeed(
                    state = uiState.listFeed,
                )
            }
        }
    )
}
