package com.cheesecake.presentation.screens.mainactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.databinding.ActivityMainBinding
import com.cheesecake.presentation.screens.favLeaguesSelection.OnboardingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            if (!mainActivityViewModel.shouldShowOnboarding()) {
                mainActivityViewModel.setOnboardingShown()

                installSplashScreen()
                binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

                val navHostFragment = supportFragmentManager
                    .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
                val controller = navHostFragment.navController

                binding.bottomNavBar.setupWithNavController(controller)
                NavigationUI.setupWithNavController(binding.bottomNavBar, controller, false)
            } else {
                navigateToOnboarding()
            }
        }


    }

    private fun navigateToOnboarding() {
        val intent = Intent(this@MainActivity, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }


}