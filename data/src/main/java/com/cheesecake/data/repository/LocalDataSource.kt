package com.cheesecake.data.repository

import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.PlayerLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDto>

    suspend fun updateOrInsertTeams(teams: List<TeamLocalDto>)

    suspend fun updateOrInsertTeam(team: TeamLocalDto)

    suspend fun getFavouriteTeams(): List<TeamLocalDto>

    suspend fun getFavouriteLeagues(): List<LeagueLocalDto>

    suspend fun getFavoritePLayers(): List<PlayerLocalDto>

    suspend fun deleteAllTeams()

    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDto?

    suspend fun updateOrInsertLeague(league: LeagueLocalDto)

    suspend fun deleteLeagueById(leagueId: Int)

    suspend fun deleteTeamById(teamId: Int)

    suspend fun deletePlayerById(playerId: Int)


}