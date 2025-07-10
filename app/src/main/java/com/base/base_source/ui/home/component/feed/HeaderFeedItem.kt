package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.base.base_source.R


@Composable
fun HeaderFeedItem(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Column(
                modifier = Modifier.align(Alignment.CenterVertically),
            ) {
                Row {
                    Text(
                        text = "Aris",
                        style = MaterialTheme.typography.titleSmall,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_blue_tick),
                        contentDescription = "Camera Icon",
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

                Text(
                    text = "Tokyo , Japan",
                    style = MaterialTheme.typography.bodySmall
                )


            }
        }



        IconButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "Camera Icon",
                modifier = Modifier
                    .size(24.dp)
            )
        }

    }
}


@Preview
@Composable
fun HeaderFeedItemPreview() {
    HeaderFeedItem(
        modifier = Modifier.fillMaxWidth()
    )
}