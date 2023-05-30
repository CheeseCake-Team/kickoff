package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleSidelinedResponse
import com.cheesecake.data.models.StandingsResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IStandingsApiService {

    @GET("standings")
    suspend fun getStandingsByTeamId(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.TEAM) teamId: Int
    ): Response<BaseResponse<StandingsResponse>>

    @GET("standings")
    suspend fun getStandingsByLeagueId(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<StandingsResponse>>

    @GET("standings")
    suspend fun getStandingsByTeamIdAndLeagueId(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.TEAM) teamId: Int,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<StandingsResponse>>
}





