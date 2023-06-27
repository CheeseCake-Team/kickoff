package com.cheesecake.data.repository

interface OnboardingDataSource {
    suspend fun shouldShowOnboarding(): Boolean

    suspend fun setOnboardingShown()
}