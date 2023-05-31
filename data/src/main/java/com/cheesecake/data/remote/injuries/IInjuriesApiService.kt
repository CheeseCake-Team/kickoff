package com.cheesecake.data.remote.injuries

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleInjuriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IInjuriesApiService {

@GET("injuries")
suspend fun getInjuriesByFixtureID(
      @Query("fixture") fixtureId: Int
):Response<BaseResponse<SingleInjuriesResponse>>

      @GET("injuries")
      suspend fun getInjuriesByLeagueIDAndSeason(
            @Query("league") leagueId:Int,
            @Query("season") season: Int

      ):Response<BaseResponse<SingleInjuriesResponse>>
      @GET("injuries")
      suspend fun getInjuriesByTeamIDAndSeason(
            @Query("team") teamId:Int,
            @Query("season") season: Int

      ):Response<BaseResponse<SingleInjuriesResponse>>
      @GET("injuries")
      suspend fun getInjuriesByPlayerIDAndSeason(
            @Query("player") playerId:Int,
            @Query("season") season: Int

      ):Response<BaseResponse<SingleInjuriesResponse>>

      @GET("injuries")
      suspend fun getInjuriesByTimeZone(
            @Query("timezone") timeZone: String,
      ):Response<BaseResponse<SingleInjuriesResponse>>
      @GET("injuries")
      suspend fun getInjuriesByDate(
            @Query("date") date: String,
      ):Response<BaseResponse<SingleInjuriesResponse>>

}
