package com.cheesecake.presentation.screens.favLeaguesSelection

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.cheesecake.presentation.screens.mainactivity.MainActivity
import com.cheesecake.presentation.R
import com.cheesecake.presentation.databinding.ActivityOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private val favViewModel: FavLeagueSelectionViewModel by viewModels()
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            if (!favViewModel.shouldShowOnboarding()) {
                favViewModel.setOnboardingShown()
                binding = DataBindingUtil.setContentView(this@OnboardingActivity, R.layout.activity_onboarding)
                binding.viewModel = favViewModel
                // Set up your views and handle navigation here
                handleNavigation()
                binding.allLeaguesRecyclerView.adapter = FavLeagueSelectionAdapter()
            } else {
                navigateToHome()
            }
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this@OnboardingActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun handleNavigation() {
        collect(favViewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: FavLeagueSelectionNavigationEvent) {
        when (event) {
            is FavLeagueSelectionNavigationEvent.NavigateToFavTeamsSelection -> navigateToHome()
        }
    }


    fun <T> collect(flow: Flow<T>, action: suspend (T) -> Unit) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collect(action)
            }
        }
    }


}