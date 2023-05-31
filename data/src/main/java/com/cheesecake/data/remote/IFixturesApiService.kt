package com.cheesecake.data.remote

import androidx.paging.DataSource
import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.FixtureResponse
import com.cheesecake.data.models.FixtureStatistics
import com.cheesecake.data.models.HeadToHeadResponse
import com.cheesecake.data.models.SingleEventResponse
import com.cheesecake.data.models.SingleFixtureResponse
import com.cheesecake.data.models.SingleLineupResponse
import com.cheesecake.data.utils.FixtureStatus
import com.cheesecake.data.utils.QueryParameters.Companion.ID
import com.cheesecake.data.utils.QueryParameters.Companion.TIMEZONE
import com.cheesecake.data.utils.QueryParameters.Companion.SEASON
import com.cheesecake.data.utils.QueryParameters.Companion.TEAM
import com.cheesecake.data.utils.QueryParameters.Companion.FIXTURE
import com.cheesecake.data.utils.QueryParameters.Companion.PLAYER
import com.cheesecake.data.utils.QueryParameters.Companion.DATE
import com.cheesecake.data.utils.QueryParameters.Companion.FROM
import com.cheesecake.data.utils.QueryParameters.Companion.TO
import com.cheesecake.data.utils.QueryParameters.Companion.TYPE
import com.cheesecake.data.utils.QueryParameters.Companion.STATUS
import com.cheesecake.data.utils.QueryParameters.Companion.CURRENT
import com.cheesecake.data.utils.QueryParameters.Companion.LEAGUE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IFixturesApiService {

    //region Rounds
    @GET("fixtures/rounds")
    suspend fun getFixtureRounds(
        @Query(SEASON) seasonId: Int,
        @Query(LEAGUE) leagueId: Int
    ): Response<BaseResponse<String>>

    @GET("fixtures/rounds")
    suspend fun getFixtureRoundsCurrentOnly(
        @Query(SEASON) seasonId: Int,
        @Query(LEAGUE) leagueId: Int,
        @Query(CURRENT) current: Boolean,
    ): Response<BaseResponse<String>>
    //endregion

    //region Fixtuers
    @GET("fixtures")
    suspend fun getFixtureById(
        @Query(TIMEZONE) timeZone: String,
        @Query(ID) fixtureId: Int
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdByTeamId(
        @Query(TIMEZONE) timeZone: String,
        @Query(SEASON) season: String,
        @Query(TEAM) teamId: Int
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query(TIMEZONE) timeZone: String,
        @Query(DATE) date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDate(
        @Query(TIMEZONE) timeZone: String,
        @Query(FROM) date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesToDate(
        @Query(TIMEZONE) timeZone: String,
        @Query(TO) date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDateToDate(
        @Query(TIMEZONE) timeZone: String,
        @Query(SEASON) season: String,
        @Query(TEAM) teamId: Int,
        @Query(FROM) from: String,
        @Query(TO) date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesStatus(
        @Query(TIMEZONE) timeZone: String,
        @Query(STATUS) fixtureStatusType: String
    ): Response<BaseResponse<SingleFixtureResponse>>


    //endregion


    //region Head 2 Head
    @GET("fixtures/headtohead")
    suspend fun getHeadToHead(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(SEASON) seasonId: Int,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByDate(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(DATE) date: String,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>
    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatus(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(STATUS) status: FixtureStatus,
        @Query(SEASON) seasonId: Int,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTO(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(FROM) from: String,
        @Query(TO) to: String,
        @Query(SEASON) seasonId: Int,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByLeague(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(LEAGUE) leagueId: Int,
        @Query(SEASON) seasonId: Int,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByByDateAndLeague(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(LEAGUE) leagueId: Int,
        @Query(DATE) date: String,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatusAndLeague(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(LEAGUE) leagueId: Int,
        @Query(STATUS) status: FixtureStatus,
        @Query(SEASON) seasonId: Int,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTOAndLeague(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String,
        @Query(LEAGUE) leagueId: Int,
        @Query(FROM) from: String,
        @Query(TO) to: String,
        @Query(SEASON) seasonId: Int,
        @Query(TIMEZONE) timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>
    //endregion

    //region Statistics
    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureId(
        @Query(FIXTURE) fixtureId: Int
    ): Response<BaseResponse<FixtureStatistics>>

    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        @Query(FIXTURE) fixtureId: Int,
        @Query(TEAM) teamId: Int
    ): Response<BaseResponse<FixtureStatistics>>
    //endregion

    //region Events
    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureId(
        @Query(FIXTURE) fixtureId: Int
    ): Response<BaseResponse<SingleEventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamId(
        @Query(FIXTURE) fixtureId: Int,
        @Query(TEAM) teamId: Int
    ): Response<BaseResponse<SingleEventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        @Query(FIXTURE) fixtureId: Int,
        @Query(TEAM) teamId: Int,
        @Query(PLAYER) playerId: Int,
    ): Response<BaseResponse<SingleEventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        @Query(FIXTURE) fixtureId: Int,
        @Query(TEAM) teamId: Int,
        @Query(PLAYER) playerId: Int,
        @Query(TYPE) fixtureEventType: String,
    ): Response<BaseResponse<SingleEventResponse>>
    //endregion

    //region Lineups
    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureId(
        @Query(FIXTURE) fixtureId: Int
    ): Response<BaseResponse<SingleLineupResponse>>


    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        @Query(FIXTURE) fixtureId: Int,
        @Query(TEAM) teamId: Int
    ): Response<BaseResponse<SingleLineupResponse>>

    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        @Query(FIXTURE) fixtureId: Int,
        @Query(PLAYER) playerId: Int
    ): Response<BaseResponse<SingleLineupResponse>>

    //endregion

    //region Players

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureId(
        @Query(FIXTURE) fixtureId: String
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureIdByTeamId(
        @Query(FIXTURE) fixtureId: Int,
        @Query(TEAM) teamId: Int
    ): Response<BaseResponse<FixtureResponse>>

    //endregion
}