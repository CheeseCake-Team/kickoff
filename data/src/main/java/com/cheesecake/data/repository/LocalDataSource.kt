package com.cheesecake.data.repository

import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.TeamLocalDto

interface LocalDataSource {

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDto>

    suspend fun updateOrInsertTeams(teams: List<TeamLocalDto>)

    suspend fun updateOrInsertTeam(team: TeamLocalDto)

    suspend fun getFavouriteTeams(): List<TeamLocalDto>

    suspend fun deleteAllTeams()

    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDto?

    suspend fun updateOrInsertLeague(league: LeagueLocalDto)

    suspend fun deleteLeagueById(leagueId: Int)

}