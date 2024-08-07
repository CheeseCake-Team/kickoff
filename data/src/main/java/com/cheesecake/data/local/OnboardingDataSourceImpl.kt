package com.cheesecake.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.cheesecake.data.repository.OnboardingDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OnboardingDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : OnboardingDataSource {

    override suspend fun readOnboardingState(): Boolean {
        return dataStore.data.map { preferences ->
            preferences[booleanPreferencesKey(ONBOARDING_SHOWN)] == true
        }.first()
    }

    override suspend fun saveOnboardingState(isCompleted: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(ONBOARDING_SHOWN)] = isCompleted
        }
    }

    companion object{
        const val ONBOARDING_SHOWN = "onboarding_complete"
    }
}