package com.base.base_source.presentation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.base.base_source.presentation.navigation.AppNavigation
import com.base.base_source.presentation.theme.BaseTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Pure Compose application entry point that showcases the full Compose + Clean Architecture integration
 * This activity demonstrates:
 * - Complete Jetpack Compose UI
 * - Clean Architecture with domain layer
 * - Navigation Compose
 * - Material Design 3 theming
 */
@AndroidEntryPoint
class FullComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}