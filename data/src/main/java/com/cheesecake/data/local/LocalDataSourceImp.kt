package com.cheesecake.data.local

import com.cheesecake.data.local.daos.FavouriteTeamDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.FavouriteTeamLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
        private val teamsDao: TeamsDao,

        private val favouriteTeamDao: FavouriteTeamDao,

        ): LocalDataSource {

    override fun getAllTeams(): Flow<List<TeamLocalDto>> {
       return teamsDao.getAllTeams()
    }

    override suspend fun upsertAll(teams: List<TeamLocalDto>) {
       teamsDao.upsertAll(teams)
    }

    override suspend fun insertTeam(favTeamDto: FavouriteTeamLocalDto) {
        favouriteTeamDao.insertTeam(favTeamDto)
    }

    override suspend fun getFavTeams(): Flow<List<FavouriteTeamLocalDto>>{

        return favouriteTeamDao.getFavTeams()

    }



    override suspend fun deleteAll() {
       teamsDao.deleteAll()
    }

}