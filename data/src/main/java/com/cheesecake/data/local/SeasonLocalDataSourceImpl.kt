package com.cheesecake.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cheesecake.data.repository.SeasonLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SeasonLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : SeasonLocalDataSource {
    override fun getSeason(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[stringPreferencesKey(SEASON)] ?: "2024"
        }
    }

    override suspend fun setSeason(season: String) {
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey(SEASON)] = season
        }
    }

    companion object {
        const val SEASON = "season"
    }
}