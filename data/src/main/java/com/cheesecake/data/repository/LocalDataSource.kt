package com.cheesecake.data.repository

import androidx.room.Query
import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.RecentSearchLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.domain.entity.RecentSearch
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

    fun getRecentSearches(): Flow<List<RecentSearchLocalDTO>>

    suspend fun updateOrInsertRecentSearches(recent: RecentSearchLocalDTO)

    suspend fun deleteRecentSearchById(recentId: Int)

    suspend fun deleteRecentSearches()

}