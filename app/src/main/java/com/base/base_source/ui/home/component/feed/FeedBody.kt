package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.base.base_source.R


@Composable
fun FeedBody(
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier,
        contentDescription = "Feed Body",
        painter = painterResource(id = R.drawable.thumbnail_1),
        contentScale = ContentScale.FillWidth

    )
}

@Preview
@Composable
fun FeedBodyPreview() {
    FeedBody()
}