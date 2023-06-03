package com.cheesecake.data.remote.injuries

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.IjuriesDTO

import retrofit2.Response
import javax.inject.Inject

class InjuriesRepository @Inject constructor(private val injuriesApiService: IInjuriesApiService) {

    suspend fun getInjuriesByFixtureID(fixtureId: Int)
            : Response<BaseResponse<IjuriesDTO>> {
        return injuriesApiService.getInjuriesByFixtureID(fixtureId)
    }


    suspend fun getInjuriesByTeamIDAndSeason(teamId: Int, season: Int):
            Response<BaseResponse<IjuriesDTO>> {
        return injuriesApiService.getInjuriesByTeamIDAndSeason(teamId, season)
    }

    suspend fun getInjuriesByPlayerIDAndSeason(playerId: Int, season: Int)
            : Response<BaseResponse<IjuriesDTO>> {
        return injuriesApiService.getInjuriesByPlayerIDAndSeason(playerId, season)
    }

    suspend fun getInjuriesByTimeZone(timeZone: String):
            Response<BaseResponse<IjuriesDTO>> {
        return injuriesApiService.getInjuriesByTimeZone(timeZone)
    }

    suspend fun getInjuriesByDate(date: String)
            : Response<BaseResponse<IjuriesDTO>> {
        return injuriesApiService.getInjuriesByDate(date)

    }

}