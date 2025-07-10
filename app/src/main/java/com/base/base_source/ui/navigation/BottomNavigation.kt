package com.base.base_source.ui.navigation

import BottomNavType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import bottomNavItems


@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    selectedTab: BottomNavType,
    onTabSelected: (BottomNavType) -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        horizontalArrangement = SpaceBetween
    ) {

        bottomNavItems.forEach { item ->
            IconButton(onClick = { onTabSelected(item) }) {
                Image(
                    painter = painterResource(
                        id = if (selectedTab == item) item.iconActive else item.iconInactive
                    ),
                    contentDescription = item.contentDescription,
                    modifier = Modifier.size(27.dp)
                )
            }
        }
    }
}