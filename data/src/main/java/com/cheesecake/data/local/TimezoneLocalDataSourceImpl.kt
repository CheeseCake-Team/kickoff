package com.cheesecake.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cheesecake.data.repository.TimezoneLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TimezoneLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) :TimezoneLocalDataSource {
    override fun getTimezone(): Flow<String> {
        return dataStore.data.map { preference ->
            preference[stringPreferencesKey(TIMEZONE)] ?: "Africa/Abidjan"
        }
    }

    override suspend fun setTimezone(timezone: String) {
        dataStore.edit { preference ->
            preference[stringPreferencesKey(TIMEZONE)] = timezone
        }
    }

    companion object {
        const val TIMEZONE = "timezone"
    }
}