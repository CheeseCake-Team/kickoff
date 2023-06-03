package com.cheesecake.data.local.dataSource

import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllTeams(): Flow<List<TeamLocalDto>>

    suspend fun upsertAll(teams: List<TeamLocalDto>)

    suspend fun deleteAll()

}