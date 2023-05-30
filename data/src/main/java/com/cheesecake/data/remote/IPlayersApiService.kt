package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SinglePlayerResponse
import com.cheesecake.data.models.SingleSquadResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlayersApiService {
    @GET("players")
    suspend fun getPlayerBySeasonByPlayerId(
        @Query(QueryParameters.SEASON) season: String,
        @Query(QueryParameters.ID) playerId: Int,
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun getPlayerBySeasonByTeamId(
        @Query(QueryParameters.SEASON) season: String,
        @Query("team") teamId: Int,
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun getPlayerBySeasonByLeagueId(
        @Query(QueryParameters.SEASON) season: String,
        @Query(QueryParameters.ID) leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun searchPlayerNameByTeamId(
        @Query(QueryParameters.SEARCH) playerName: String,
        @Query(QueryParameters.TEAM) teamId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun searchPlayerNameByLeagueId(
        @Query(QueryParameters.SEARCH) playerName: String,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/seasons")
    suspend fun getPlayerSeasons(): Response<BaseResponse<Int>>

    @GET("players/squads")
    suspend fun getSquadByPlayerId(
        @Query(QueryParameters.PLAYER) playerId: Int
    ): Response<BaseResponse<SingleSquadResponse>>

    @GET("players/squads")
    suspend fun getSquadByTeamId(
        @Query(QueryParameters.TEAM) teamId: Int
    ): Response<BaseResponse<SingleSquadResponse>>

    @GET("players/topscorers")
    suspend fun getTopScorers(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/topassists")
    suspend fun getTopAssists(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/topyellowcards")
    suspend fun getTopYellowCards(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/topredcards")
    suspend fun getTopRedCards(
        @Query(QueryParameters.SEASON) seasonId: Int,
        @Query(QueryParameters.LEAGUE) leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

}