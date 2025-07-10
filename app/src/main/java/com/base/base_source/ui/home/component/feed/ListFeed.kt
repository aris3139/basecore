package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun LazyListScope.listFeed(
    modifier: Modifier = Modifier
) {
    items(10) { index ->
        FeedItem(
            modifier = modifier
        )
    }
}