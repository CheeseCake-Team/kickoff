package com.cheesecake.data.local

import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.RecentSearchDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.daos.TeamCountriesDao
import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.RecentSearchLocalDTO
import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.data.repository.LocalDataSource
import com.cheesecake.data.repository.SeasonLocalDataSource
import com.cheesecake.data.repository.TimezoneLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val teamsDao: TeamsDao,
    private val leagueDao: LeagueDao,
    private val teamCountriesDao: TeamCountriesDao,
    private val searchDao: RecentSearchDao,
    private val seasonLocalDataSource: SeasonLocalDataSource,
    private val timezoneLocalDataSource: TimezoneLocalDataSource,
) : LocalDataSource {

    override fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO> {
        return teamsDao.getLocallyTeamsByLeagueIdAndSeason(leagueId, season)
    }

    override suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>) {
        teamsDao.updateOrInsertTeams(teams)
    }

    override suspend fun getFavouriteTeams(): Flow<List<TeamLocalDTO>> {
        return teamsDao.getFavouriteTeams()
    }

    override suspend fun updateOrInsertTeam(team: TeamLocalDTO) {
        teamsDao.updateOrInsertTeam(team)
    }

    override suspend fun deleteAllTeams() {
        teamsDao.deleteAllTeams()
    }

    override suspend fun getLeagueByIdAndSeason(leagueId: Int,): LeagueLocalDTO? {
        return leagueDao.getLeagueByIdAndSeason(leagueId)
    }

    override suspend fun updateOrInsertLeague(league: LeagueLocalDTO) {
        leagueDao.updateOrInsertLeagueLocalDto(league)
    }

    override suspend fun deleteLeagueById(leagueId: Int) {
        leagueDao.deleteLeagueById(leagueId)
    }

    override suspend fun getLocalCountries(): List<TeamCountriesLocalDTO> {
        return teamCountriesDao.getLocalCountries()
    }

    override suspend fun getCountriesSearch(search: String): Flow<List<TeamCountriesLocalDTO>> {
        return teamCountriesDao.getCountriesSearch(search)
    }


    override suspend fun addTeamCountries(teams: List<TeamCountriesLocalDTO>) {
        teamCountriesDao.addTeamCountries(teams)
    }


    override suspend fun deleteTeamById(teamId: Int) {
        teamsDao.deleteTeamById(teamId)
    }

    override suspend fun getTeamById(teamId: Int): TeamLocalDTO? {
        return teamsDao.getTeamById(teamId)
    }

    override suspend fun addTeamsList(teams: List<TeamLocalDTO>) {
        teamsDao.updateOrInsertTeams(teams)
    }

    override fun getSeason(): Flow<String> {
        return seasonLocalDataSource.getSeason()
    }

    override suspend fun setSeason(season: String) {
        seasonLocalDataSource.setSeason(season)
    }

    override fun getTimezone(): Flow<String> {
        return timezoneLocalDataSource.getTimezone()
    }

    override suspend fun setTimezone(timezone: String) {
        timezoneLocalDataSource.setTimezone(timezone)
    }

    override suspend fun getFavouriteLeagues(): Flow<List<LeagueLocalDTO>> {
        return leagueDao.getFavouriteLeagues()
    }

    override suspend fun addLeaguesList(leagues: List<LeagueLocalDTO>) {
        leagueDao.insertLeagueList(leagues)

    }

    override fun getRecentSearches(): Flow<List<RecentSearchLocalDTO>> {
        return searchDao.getAllRecentSearches()
    }

    override suspend fun updateOrInsertRecentSearches(recent: RecentSearchLocalDTO) {
        searchDao.updateOrInsertRecentSearch(recent)
    }

    override suspend fun deleteRecentSearchById(recentId: Int) {
        searchDao.deleteRecentSearchById(recentId)
    }

    override suspend fun deleteRecentSearches() {
        searchDao.deleteRecentSearches()
    }


}