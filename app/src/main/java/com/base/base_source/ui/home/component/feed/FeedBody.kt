package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.base.base_source.R


@Composable
fun FeedBody(
    modifier: Modifier = Modifier,
) {
    val images = listOf(
        R.drawable.thumbnail_1,
        R.drawable.thumbnai_2,
        R.drawable.thumbnai_4,
        R.drawable.thumbnai_5,
        R.drawable.thumbnai_3,
        R.drawable.thumbnai_6,
        R.drawable.thumbnai_7,
        R.drawable.thumbnai_8,
    )
    val imgId = remember { images.random() }


    Image(
        modifier = modifier,
        contentDescription = "Feed Body",
        painter = painterResource(id = imgId),
        contentScale = ContentScale.FillWidth

    )
}

@Preview
@Composable
fun FeedBodyPreview() {
    FeedBody()
}