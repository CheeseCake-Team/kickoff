package com.cheesecake.data.remote.standings

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.StandingsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IStandingsApiService {

    @GET("standings")
    suspend fun getStandingsByTeamId(
        @Query("season") seasonId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<StandingsDTO>>

    @GET("standings")
    suspend fun getStandingsByLeagueId(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<StandingsDTO>>

    @GET("standings")
    suspend fun getStandingsByTeamIdAndLeagueId(
        @Query("season") seasonId: Int,
        @Query("team") teamId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<StandingsDTO>>
}





