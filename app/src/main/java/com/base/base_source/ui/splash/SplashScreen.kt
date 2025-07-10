package com.base.base_source.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.base.base_source.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToHome: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(1000)
        navigateToHome()
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_instagram),
            contentDescription = "Splash Image",
            modifier = Modifier.size(200.dp, 200.dp)
        )
    }
}