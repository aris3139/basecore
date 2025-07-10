package com.base.base_source.ui.home.component.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.base.base_source.R

@Composable
fun FeedFooter(
    modifier: Modifier = Modifier,
    description: String = "lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris"
) {
    Column(
        modifier = modifier

    ) {
        // action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_nav_follow_unactive),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_messanger),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "Like Icon",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "Liked by Aris and 44,644 others",
                modifier = Modifier,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall
            )
        }

        Text(
            text = description,
            modifier = Modifier.padding(horizontal = 12.dp),
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun FeedFooterPreview() {
    FeedFooter()
}