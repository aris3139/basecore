package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.base.base_source.domain.model.Feed

@Composable
fun FeedItem(
    modifier: Modifier = Modifier,
    feed: Feed
) {
    Column(
        modifier = modifier
    ) {
        HeaderFeedItem(
            modifier = Modifier
                .fillMaxWidth(),
            username = feed.username,
            place = feed.place,
        )
        FeedBody(
            modifier = Modifier
                .fillMaxWidth(),
        )
        FeedFooter(
            modifier = Modifier
                .fillMaxWidth(),
            description = feed.description,

            )
    }
}

@Preview
@Composable
fun FeedItemPreview() {
    FeedItem(
        feed = Feed(
            id = "",
            username = "Aris",
            place = "Tokyo, Japan",
            description = "This is a sample feed description.",
            avatar = null
        )
    )
}