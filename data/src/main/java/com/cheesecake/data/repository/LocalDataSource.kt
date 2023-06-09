package com.cheesecake.data.repository

import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO

interface LocalDataSource {

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO>

    suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>)

    suspend fun updateOrInsertTeam(team: TeamLocalDTO)

    suspend fun getFavouriteTeams(): List<TeamLocalDTO>

    suspend fun deleteAllTeams()

    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDTO?

    suspend fun updateOrInsertLeague(league: LeagueLocalDTO)

    suspend fun deleteLeagueById(leagueId: Int)

}