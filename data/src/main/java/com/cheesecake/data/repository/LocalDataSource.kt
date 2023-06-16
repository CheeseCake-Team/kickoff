package com.cheesecake.data.repository

import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO>

    suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>)

    suspend fun addTeamCountries(teams:List<TeamCountriesLocalDTO>)

    suspend fun updateOrInsertTeam(team: TeamLocalDTO)

    suspend fun getFavouriteTeams(): List<TeamLocalDTO>

    suspend fun deleteAllTeams()

    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDTO?

    suspend fun updateOrInsertLeague(league: LeagueLocalDTO)

    suspend fun deleteLeagueById(leagueId: Int)

    suspend fun getLocalCountries(): List<TeamCountriesLocalDTO>

    suspend fun getCountriesSearch(search: String): Flow<List<TeamCountriesLocalDTO>>

}