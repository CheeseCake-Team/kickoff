package com.cheesecake.data.local

import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.PlayerDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.PlayerLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.data.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val teamsDao: TeamsDao,
    private val leagueDao: LeagueDao,
    private val playerDao: PlayerDao
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


    override suspend fun deleteAllTeams() {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrInsertTeam(team: TeamLocalDto) {
        teamsDao.updateOrInsertTeam(team)
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

    override suspend fun deleteTeamById(teamId: Int) {
        teamsDao.deleteTeamById(teamId)
    }

    override suspend fun deletePlayerById(playerId: Int) {
        playerDao.deletePlayerById(playerId)
    }

    override suspend fun getFavouriteLeagues(): List<LeagueLocalDto> {
        return leagueDao.getFavouriteLeague()
    }

    override suspend fun getFavoritePLayers(): List<PlayerLocalDto> {
        return playerDao.getFavouritePlayers()
    }

}