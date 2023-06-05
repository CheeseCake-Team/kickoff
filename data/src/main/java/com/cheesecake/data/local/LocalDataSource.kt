package com.cheesecake.data.local

import com.cheesecake.data.local.models.FavouriteTeamLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllTeams(): Flow<List<TeamLocalDto>>
    suspend fun getFavTeams(): Flow<List<FavouriteTeamLocalDto>>

    suspend fun upsertAll(teams: List<TeamLocalDto>)
    suspend fun insertTeam(favTeamDto: FavouriteTeamLocalDto)

    suspend fun deleteAll()


}