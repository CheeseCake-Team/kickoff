package com.cheesecake.data.repository

import com.cheesecake.data.local.models.CompetitionLocalDto
import com.cheesecake.data.local.models.RecentSearchLocalDTO
import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO>

    suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>)

    suspend fun addTeamCountries(teams: List<TeamCountriesLocalDTO>)

    suspend fun updateOrInsertTeam(team: TeamLocalDTO)

    suspend fun getFavouriteTeams(): Flow<List<TeamLocalDTO>>

    suspend fun getFavouriteLeagues(): Flow<List<CompetitionLocalDto>>

    suspend fun deleteAllTeams()

    suspend fun getLeagueByIdAndSeason(leagueId: Int): CompetitionLocalDto?

    suspend fun upsertCompetition(competitionLocalDto: CompetitionLocalDto)

    suspend fun deleteLeagueById(leagueId: Int)

    suspend fun getLocalCountries(): List<TeamCountriesLocalDTO>

    suspend fun getCountriesSearch(search: String): Flow<List<TeamCountriesLocalDTO>>

    suspend fun addLeaguesList(leagues: List<CompetitionLocalDto>)

    suspend fun deleteTeamById(teamId: Int)

    fun getRecentSearches(): Flow<List<RecentSearchLocalDTO>>

    suspend fun updateOrInsertRecentSearches(recent: RecentSearchLocalDTO)

    suspend fun deleteRecentSearchById(recentId: Int)

    suspend fun deleteRecentSearches()

    suspend fun getTeamById(teamId: Int): TeamLocalDTO?

    suspend fun addTeamsList(teams: List<TeamLocalDTO>)

    fun getSeason(): Flow<String>

    suspend fun setSeason(season: String)

    fun getTimezone(): Flow<String>

    suspend fun setTimezone(timezone: String)
}