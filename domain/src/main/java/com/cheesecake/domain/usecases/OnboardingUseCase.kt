package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class OnboardingUseCase @Inject constructor(private val footballRepository: IFootballRepository) {


    suspend fun shouldShowOnboarding(): Boolean = footballRepository.shouldShowOnboarding()

    suspend fun setOnboardingShown() { footballRepository.setOnboardingShown() }
}