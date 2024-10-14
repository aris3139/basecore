package com.base.base_source.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.base.base_source.R
import com.base.base_source.databinding.ActivityMainBinding
import com.base.base_source.datastore.DataStoreManager
import com.base.base_source.extentions.allowReads
import com.base.base_source.extentions.collectIn
import com.base.base_source.extentions.setStatusBarColor
import com.base.base_source.preference.Settings
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var uiStateJob: Job? = null

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        findNavController(R.id.nav_host_fragment_content_main)
    }

    override fun onDestroy() {
        if (isTaskRoot && isFinishing) {
            finishAfterTransition()
        }
        super.onDestroy()
    }

    override fun onStop() {
        uiStateJob?.cancel()
        super.onStop()
    }

    private fun setupUI() {
        lifecycleScope.launch {
            dataStoreManager.themeMode.collectIn(this@MainActivity) { mode ->
                setNightMode(mode)
            }
        }
    }

    private fun setNightMode(mode: Int) {
        allowReads {
            uiStateJob = lifecycleScope.launchWhenStarted {
                dataStoreManager.setThemeMode(mode)
            }
        }
        when (mode) {
            AppCompatDelegate.MODE_NIGHT_NO -> applyThemeMode(
                AppCompatDelegate.MODE_NIGHT_YES,
                R.drawable.ic_mode_night_default_black
            )

            AppCompatDelegate.MODE_NIGHT_YES -> applyThemeMode(
                Settings.MODE_NIGHT_DEFAULT,
                R.drawable.ic_mode_night_no_black
            )

            else -> applyThemeMode(
                AppCompatDelegate.MODE_NIGHT_NO,
                R.drawable.ic_mode_night_yes_black
            )
        }
    }

    private fun applyThemeMode(themeMode: Int, @DrawableRes icon: Int) {
        setStatusBarColor(R.color.status_bar)
        if (AppCompatDelegate.getDefaultNightMode() != themeMode) {
            AppCompatDelegate.setDefaultNightMode(themeMode)
            window?.setWindowAnimations(R.style.WindowAnimationFadeInOut)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_userInfo -> {
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
