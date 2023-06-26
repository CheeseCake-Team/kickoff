package com.cheesecake.presentation.screens.onboardingactivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.databinding.ActivityOnboardingBinding
import com.cheesecake.presentation.screens.favLeaguesSelection.FavLeagueSelectionViewModel
import com.cheesecake.presentation.screens.favLeaguesSelection.FavLeaguesSelectionFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil
            .setContentView(this@OnboardingActivity, R.layout.activity_onboarding)

    }

}