package com.cheesecake.data.local

import com.cheesecake.data.local.daos.LeagueDao import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.data.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val teamsDao: TeamsDao,
    private val leagueDao: LeagueDao,
) : LocalDataSource {

    override fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO> {
        return teamsDao.getLocallyTeamsByIdAndSeason(leagueId, season)
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

    override suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDTO? {
        return leagueDao.getLeagueByIdAndSeason(leagueId, leagueSeason)
    }

    override suspend fun updateOrInsertLeague(league: LeagueLocalDTO) {
        leagueDao.updateOrInsertLeagueLocalDto(league)
    }

    override suspend fun deleteLeagueById(leagueId: Int) {
        leagueDao.deleteLeagueById(leagueId)
    }

    override suspend fun deleteTeamById(teamId: Int) {
        teamsDao.deleteTeamById(teamId)
    }

    override suspend fun getFavouriteLeagues(): Flow<List<LeagueLocalDTO>> {
        return leagueDao.getFavouriteLeagues()
    }

}