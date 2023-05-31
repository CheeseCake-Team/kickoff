package com.cheesecake.data.remote.player

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SinglePlayerResponse
import com.cheesecake.data.models.SingleSquadResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlayersApiService {

    @GET("players")
    suspend fun getPlayerBySeasonByPlayerId(
        @Query("season") season: String,
        @Query("id") playerId: Int,
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun getPlayerBySeasonByTeamId(
        @Query("season") season: String,
        @Query("team") teamId: Int,
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun getPlayerBySeasonByLeagueId(
        @Query("season") season: String,
        @Query("id") leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun searchPlayerNameByTeamId(
        @Query("search") playerName: String,
        @Query("team") teamId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players")
    suspend fun searchPlayerNameByLeagueId(
        @Query("search") playerName: String,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/seasons")
    suspend fun getPlayerSeasons(): Response<BaseResponse<Int>>

    @GET("players/squads")
    suspend fun getSquadByPlayerId(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SingleSquadResponse>>

    @GET("players/squads")
    suspend fun getSquadByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<SingleSquadResponse>>

    @GET("players/topscorers")
    suspend fun getTopScorers(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/topassists")
    suspend fun getTopAssists(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/topyellowcards")
    suspend fun getTopYellowCards(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

    @GET("players/topredcards")
    suspend fun getTopRedCards(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<SinglePlayerResponse>>

}