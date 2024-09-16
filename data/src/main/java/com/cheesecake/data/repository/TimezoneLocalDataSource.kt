package com.cheesecake.data.repository

import kotlinx.coroutines.flow.Flow

interface TimezoneLocalDataSource {
    fun getTimezone(): Flow<String>

    suspend fun setTimezone(timezone: String)
}