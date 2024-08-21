package com.cheesecake.data.repository

import kotlinx.coroutines.flow.Flow

interface SeasonLocalDataSource {
    fun getSeason(): Flow<String>

    suspend fun setSeason(season: String)
}