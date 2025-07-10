package com.base.base_source.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.base.base_source.R


@Composable
fun Header(
    modifier: Modifier = Modifier,
    onCameraClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp , vertical = 4.dp),
    ) {
        IconButton(
            onClick = { onCameraClick() },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_camera),
                contentDescription = "Camera Icon",
                modifier = Modifier
                    .size(32.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_home_insta),
            contentDescription = "Camera Icon",
            modifier = Modifier.align(Alignment.Center)
        )


        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            IconButton(
                onClick = {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notification Icon",
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(2.dp))
            IconButton(
                onClick = {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_messanger),
                    contentDescription = "Messenger Icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}