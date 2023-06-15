package com.cheesecake.data.local

import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.TeamCountriesDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.data.repository.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val teamsDao: TeamsDao,
    private val leagueDao: LeagueDao,
    private val teamCountriesDao: TeamCountriesDao,
) : LocalDataSource {

    override fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO> {
        return teamsDao.getLocallyTeamsByIdAndSeason(leagueId, season)
    }

    override suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>) {
        teamsDao.updateOrInsertTeams(teams)
    }


    override suspend fun getFavouriteTeams(): List<TeamLocalDTO> {
        return teamsDao.getFavouriteTeams()
    }

    override suspend fun updateOrInsertTeam(team: TeamLocalDTO) {
        teamsDao.updateOrInsertTeam(team)
    }

    override suspend fun deleteAllTeams() {
        teamsDao.deleteAllTeams()
    }

    override suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDTO? {
        return leagueDao.getLeagueByIdAndSeason(leagueId, leagueSeason)
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

    override suspend fun addTeamCountries(teams: List<TeamCountriesLocalDTO>) {
        teamCountriesDao.addTeamCountries(teams)
    }


}