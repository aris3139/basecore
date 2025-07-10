package com.base.base_source.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.base.base_source.extentions.CustomSpacer
import com.base.base_source.navigation.FeedDetail
import com.base.base_source.ui.home.component.Header
import com.base.base_source.ui.home.component.story.ListStory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToFeedDetail: (FeedDetail) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Scaffold(
        topBar = {
            Header(
                modifier = Modifier.padding(
                    top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                CustomSpacer(
                    height = 1.dp,
                    color = Color.LightGray
                )
                ListStory(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                CustomSpacer(
                    height = 1.dp,
                    color = Color.LightGray
                )
            }

        }
    )
}
