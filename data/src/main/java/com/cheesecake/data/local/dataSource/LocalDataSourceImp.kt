package com.cheesecake.data.local.dataSource

import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
        private val teamsDao: TeamsDao,
): LocalDataSource {

    override fun getAllTeams(): Flow<List<TeamLocalDto>> {
       return teamsDao.getAllTeams()
    }

    override suspend fun upsertAll(teams: List<TeamLocalDto>) {
       teamsDao.upsertAll(teams)
    }

    override suspend fun deleteAll() {
       teamsDao.deleteAll()
    }

}