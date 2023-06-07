package com.cheesecake.data.local

import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.FavouriteTeamLocalDto
import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.data.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val teamsDao: TeamsDao,
    private val leagueDao: LeagueDao,

    ) : LocalDataSource {

    override fun getAllTeams(): Flow<List<TeamLocalDto>> {
        return teamsDao.getAllTeams()
    }

    override suspend fun upsertAll(teams: List<TeamLocalDto>) {
        teamsDao.upsertAll(teams)
    }

    override suspend fun insertTeam(favTeamDto: FavouriteTeamLocalDto) {
        //favouriteTeamDao.insertTeam(favTeamDto)
    }

    override suspend fun getFavTeams(): Flow<List<FavouriteTeamLocalDto>> {

        //return favouriteTeamDao.getFavTeams()
        TODO("NOT IMPLEMENTED YET")
    }


    override fun getLeague(): Flow<List<LeagueLocalDto>> {
        return leagueDao.getLeague()
    }


    override suspend fun deleteAll() {
       teamsDao.deleteAll()
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