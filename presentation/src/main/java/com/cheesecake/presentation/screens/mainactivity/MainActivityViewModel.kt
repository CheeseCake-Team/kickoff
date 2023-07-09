package com.cheesecake.presentation.screens.mainactivity

import androidx.lifecycle.ViewModel
import com.cheesecake.domain.usecases.OnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val onboardingUseCase: OnboardingUseCase
) : ViewModel() {
    suspend fun shouldShowOnboarding() =
        onboardingUseCase.shouldShowOnboarding()

}