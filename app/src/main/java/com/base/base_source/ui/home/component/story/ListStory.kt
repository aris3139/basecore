package com.base.base_source.ui.home.component.story

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.base.base_source.R


@Composable
fun ListStory(
    modifier: Modifier
) {
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    LazyRow(
        state = listState,
        flingBehavior = flingBehavior
    ) {
        items(10) { index ->
            StoryAvatar(
                imageRes = R.drawable.ic_user,
                username = "User $index",
                modifier = modifier.padding(horizontal = 16.dp)
            )
        }
    }
}