package com.cheesecake.data.remote.fixture

import androidx.paging.DataSource
import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.FixtureResponse
import com.cheesecake.data.models.FixtureStatistics
import com.cheesecake.data.models.HeadToHeadResponse
import com.cheesecake.data.models.SingleEventResponse
import com.cheesecake.data.models.SingleFixtureResponse
import com.cheesecake.data.models.SingleLineupResponse
import com.cheesecake.data.utils.FixtureStatus
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IFixturesApiService {

    //region Rounds
    @GET("fixtures/rounds")
    suspend fun getFixtureRounds(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<String>>

    @GET("fixtures/rounds")
    suspend fun getFixtureRoundsCurrentOnly(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int,
        @Query("current") current: Boolean,
    ): Response<BaseResponse<String>>
    //endregion

    //region Fixtuers
    @GET("fixtures")
    suspend fun getFixtureById(
        @Query("timezone") timeZone: String,
        @Query("id") fixtureId: Int
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdByTeamId(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("timezone") timeZone: String,
        @Query("date") date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDate(
        @Query("timezone") timeZone: String,
        @Query("from") date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesToDate(
        @Query("timezone") timeZone: String,
        @Query("to") date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDateToDate(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int,
        @Query("from") from: String,
        @Query("to") date: String
    ): Response<BaseResponse<SingleFixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesStatus(
        @Query("timezone") timeZone: String,
        @Query("status") fixtureStatusType: String
    ): Response<BaseResponse<SingleFixtureResponse>>


    //endregion

    //region Head 2 Head
    @GET("fixtures/headtohead")
    suspend fun getHeadToHead(
        @Query("h2h") teamsId: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByDate(
        @Query("h2h") teamsId: String,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>
    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatus(
        @Query("h2h") teamsId: String,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTO(
        @Query("h2h") teamsId: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByByDateAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatusAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTOAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>>
    //endregion

    //region Statistics
    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<FixtureStatistics>>

    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<FixtureStatistics>>
    //endregion

    //region Events
    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<SingleEventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<SingleEventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
    ): Response<BaseResponse<SingleEventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
        @Query("type") fixtureEventType: String,
    ): Response<BaseResponse<SingleEventResponse>>
    //endregion

    //region Lineups
    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<SingleLineupResponse>>


    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<SingleLineupResponse>>

    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        @Query("fixture") fixtureId: Int,
        @Query("player") playerId: Int
    ): Response<BaseResponse<SingleLineupResponse>>

    //endregion

    //region Players

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureId(
        @Query("fixture") fixtureId: String
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<FixtureResponse>>

    //endregion
}