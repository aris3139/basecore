package com.base.base_source.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.base.base_source.activities.MainActivity
import com.base.base_source.databinding.ActivitySplashBinding
import com.base.base_source.presentation.compose.ComposeMainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Add buttons to choose between traditional and compose UI
        setupChoiceButtons()
    }
    
    private fun setupChoiceButtons() {
        // For now, let's navigate to Compose by default after delay
        // In a real app, you might want to provide choice buttons
        lifecycleScope.launch {
            delay(1000)
            // Navigate to Compose version by default to showcase the new architecture
            val composeIntent = Intent(this@SplashActivity, ComposeMainActivity::class.java)
            startActivity(composeIntent)
            finish()
        }
    }

    override fun onDestroy() {
        if (isTaskRoot && isFinishing) {
            finishAfterTransition()
        }
        super.onDestroy()
    }
}