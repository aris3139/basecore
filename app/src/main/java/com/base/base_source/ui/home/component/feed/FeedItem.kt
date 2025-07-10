package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FeedItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        HeaderFeedItem()
        FeedBody(
            modifier = Modifier
                .fillMaxWidth()
        )
        FeedFooter(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun FeedItemPreview() {
    FeedItem()
}