package com.cheesecake.data.remote.injuries

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleInjuriesResponse

import retrofit2.Response
import javax.inject.Inject

class InjuriesRepository @Inject constructor(private val injuriesApiService: IInjuriesApiService) {

    suspend fun getInjuriesByFixtureID(fixtureId: Int)
    :Response<BaseResponse<SingleInjuriesResponse>> {
        return injuriesApiService.getInjuriesByFixtureID(fixtureId)
    }


    suspend fun getInjuriesByTeamIDAndSeason(teamId:Int, season: Int):
            Response<BaseResponse<SingleInjuriesResponse>>{
        return injuriesApiService.getInjuriesByTeamIDAndSeason(teamId,season)
    }

    suspend fun getInjuriesByPlayerIDAndSeason(playerId:Int,season: Int)
    :Response<BaseResponse<SingleInjuriesResponse>>{
        return injuriesApiService.getInjuriesByPlayerIDAndSeason(playerId,season)
    }
    suspend fun getInjuriesByTimeZone(timeZone: String):
            Response<BaseResponse<SingleInjuriesResponse>>{
        return injuriesApiService.getInjuriesByTimeZone(timeZone)
    }
    suspend fun getInjuriesByDate(date: String)
    :Response<BaseResponse<SingleInjuriesResponse>>{
        return injuriesApiService.getInjuriesByDate(date)

    }

}