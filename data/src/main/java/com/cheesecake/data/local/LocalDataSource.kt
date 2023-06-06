package com.cheesecake.data.local

import com.cheesecake.data.local.models.FavouriteTeamLocalDto
import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllTeams(): Flow<List<TeamLocalDto>>
    suspend fun getFavTeams(): Flow<List<FavouriteTeamLocalDto>>

    suspend fun upsertAll(teams: List<TeamLocalDto>)
    suspend fun insertTeam(favTeamDto: FavouriteTeamLocalDto)

    fun getLeague(): Flow<List<LeagueLocalDto>>
    suspend fun deleteAll()

    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDto?

    suspend fun updateOrInsertLeague(league: LeagueLocalDto)

    suspend fun deleteAllUnFavouriteLeagues()

}