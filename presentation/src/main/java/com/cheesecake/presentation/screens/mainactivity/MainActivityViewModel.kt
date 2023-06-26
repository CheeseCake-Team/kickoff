package com.cheesecake.presentation.screens.mainactivity

import androidx.lifecycle.ViewModel
import com.cheesecake.domain.usecases.OnboardingUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val onboardingUseCase: OnboardingUseCase
) : ViewModel() {
    suspend fun shouldShowOnboarding() =
        onboardingUseCase.shouldShowOnboarding()


    suspend fun setOnboardingShown() {
        onboardingUseCase.setOnboardingShown()
    }

}