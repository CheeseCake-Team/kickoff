package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class OnboardingUseCase @Inject constructor(private val footballRepository: IFootballRepository) {
    suspend fun readOnboardingState(): Boolean = footballRepository.readOnboardingState()

    suspend fun saveOnboardingState(isComplete: Boolean) {
        footballRepository.saveOnboardingState(isComplete)
    }
}