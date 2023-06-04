package com.cheesecake.data.repository.injuries

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.IjuriesDTO
import com.cheesecake.data.remote.RemoteDataSource

import retrofit2.Response
import javax.inject.Inject

class InjuriesRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getInjuriesByFixtureID(fixtureId: Int)
            : List<IjuriesDTO> {
        return remoteDataSource.getInjuriesByFixtureID(fixtureId)
    }


    suspend fun getInjuriesByTeamIDAndSeason(teamId: Int, season: Int):
            List<IjuriesDTO> {
        return remoteDataSource.getInjuriesByTeamIDAndSeason(teamId, season)
    }

    suspend fun getInjuriesByPlayerIDAndSeason(playerId: Int, season: Int)
            : List<IjuriesDTO> {
        return remoteDataSource.getInjuriesByPlayerIDAndSeason(playerId, season)
    }

    suspend fun getInjuriesByTimeZone(timeZone: String):
            List<IjuriesDTO> {
        return remoteDataSource.getInjuriesByTimeZone(timeZone)
    }

    suspend fun getInjuriesByDate(date: String)
            : List<IjuriesDTO> {
        return remoteDataSource.getInjuriesByDate(date)

    }

}