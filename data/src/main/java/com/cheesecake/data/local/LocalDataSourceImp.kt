package com.cheesecake.data.local

import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.data.repository.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val teamsDao: TeamsDao,
    private val leagueDao: LeagueDao,
) : LocalDataSource {

    override fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDto> {
        return teamsDao.getLocallyTeamsByIdAndSeason(leagueId, season)
    }

    override suspend fun updateOrInsertTeams(teams: List<TeamLocalDto>) {
        teamsDao.updateOrInsertTeams(teams)
    }

    override suspend fun getFavouriteTeams(): List<TeamLocalDto> {
        return teamsDao.getFavouriteTeams()
    }

    override suspend fun updateOrInsertTeam(team: TeamLocalDto) {
        teamsDao.updateOrInsertTeam(team)
    }

    override suspend fun deleteAllTeams() {
        teamsDao.deleteAllTeams()
    }

    override suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDto? {
        return leagueDao.getLeagueByIdAndSeason(leagueId, leagueSeason)
    }

    override suspend fun updateOrInsertLeague(league: LeagueLocalDto) {
        leagueDao.updateOrInsertLeagueLocalDto(league)
    }

    override suspend fun deleteLeagueById(leagueId: Int) {
        leagueDao.deleteLeagueById(leagueId)
    }

}