package com.base.base_source.extentions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex

@Composable
fun Dp.Space() = Spacer(
    modifier = Modifier
        .height(this)
        .width(this)
)

@Composable
fun CustomSpacer(height: Dp, color: Color = Color.Transparent) {
    Spacer(
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
            .zIndex(2f)
            .background(color)
    )
}


