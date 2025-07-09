package com.base.base_source.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoginScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Login")
    }
}