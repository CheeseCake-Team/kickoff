package com.cheesecake.data.repository

import com.cheesecake.data.repository.models.response.mapToDomain
import com.cheesecake.domain.entity.PlayerEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class IFootballRepositoryImpl
@Inject constructor(private val remoteDataSource: RemoteDataSource) : IFootballRepository {
    override suspend fun getSinglePlayerCompact(season: String, teamId: Int): List<PlayerEntity> {
        return remoteDataSource.getPlayerBySeasonByTeamId(season, teamId).mapToDomain()
    }
}