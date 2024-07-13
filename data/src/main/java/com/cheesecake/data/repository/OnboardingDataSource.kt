package com.cheesecake.data.repository

interface OnboardingDataSource {
    suspend fun readOnboardingState(): Boolean

    suspend fun saveOnboardingState(isCompleted: Boolean)
}