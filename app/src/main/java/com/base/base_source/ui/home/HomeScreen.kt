package com.base.base_source.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.base.base_source.navigation.FeedDetail


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToFeedDetail: (FeedDetail) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            title = { Text("Home") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                onNavigateToFeedDetail(
                    FeedDetail(
                        feedId = "feed123",
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Product Detail")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { onNavigateToSettings() },
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("Go to Settings")
        }
    }
}
