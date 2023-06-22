package com.cheesecake.data.repository

import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO>

    suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>)

    suspend fun updateOrInsertTeam(team: TeamLocalDTO)

    suspend fun getFavouriteTeams(): Flow<List<TeamLocalDTO>>

    suspend fun getFavouriteLeagues(): Flow<List<LeagueLocalDTO>>

    suspend fun deleteAllTeams()

    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDTO?

    suspend fun updateOrInsertLeague(league: LeagueLocalDTO)

    suspend fun deleteLeagueById(leagueId: Int)

    suspend fun deleteTeamById(teamId: Int)

    suspend fun getTeamById(teamId: Int): TeamLocalDTO?

}