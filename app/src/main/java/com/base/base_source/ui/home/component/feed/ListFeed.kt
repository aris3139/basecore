package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import com.base.base_source.domain.model.Feed
import com.base.base_source.ui.base.ComponentState

fun LazyListScope.listFeed(
    modifier: Modifier = Modifier,
    state: ComponentState<List<Feed>>,

    ) {

    when (state) {
        is ComponentState.Empty -> {}
        is ComponentState.Error -> TODO()
        is ComponentState.Loading -> {}
        is ComponentState.Success -> {
            state.data.forEach { item ->
                item {
                    FeedItem(
                        modifier = modifier,
                        feed = item
                    )
                }
            }
        }
    }
}