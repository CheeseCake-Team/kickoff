package com.cheesecake.data.remote.fixture

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.FixturesDTO
import com.cheesecake.data.models.FixtureStatisticsDTO
import com.cheesecake.data.models.HeadToHeadResponse
import com.cheesecake.data.models.EventDTO
import com.cheesecake.data.models.SingleFixtureResponse
import com.cheesecake.data.models.LineupDTO
import com.cheesecake.data.utils.FixtureStatus
import retrofit2.Response
import javax.inject.Inject

class FixturesRepository @Inject constructor(private val fixturesApiService: IFixturesApiService) {

    //region ROUNDS
    suspend fun getFixtureRounds(seasonId: Int, leagueId: Int): Response<BaseResponse<String>> {
        return fixturesApiService.getFixtureRounds(seasonId, leagueId)
    }

    suspend fun getFixtureRoundsCurrentOnly(
        seasonId: Int,
        leagueId: Int,
        current: Boolean
    ): Response<BaseResponse<String>> {
        return fixturesApiService.getFixtureRoundsCurrentOnly(seasonId, leagueId, current)
    }

    //endregion

    //region FIXTURES
    suspend fun getFixtureById(
        timeZone: String,
        fixtureId: Int
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixtureById(timeZone, fixtureId)
    }

    suspend fun getFixturesBySeasonIdByTeamId(
        timeZone: String,
        season: String,
        teamId: Int
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixturesBySeasonIdByTeamId(timeZone, season, teamId)
    }

    suspend fun getFixturesByDate(
        timeZone: String,
        date: String
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixturesByDate(timeZone, date)
    }

    suspend fun getFixturesFromDate(
        timeZone: String,
        date: String
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixturesFromDate(timeZone, date)
    }

    suspend fun getFixturesToDate(
        timeZone: String,
        date: String
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixturesToDate(timeZone, date)
    }

    suspend fun getFixturesFromDateToDate(
        timeZone: String,
        season: String,
        teamId: Int,
        from: String,
        to: String
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixturesFromDateToDate(timeZone, season, teamId, from, to)
    }

    suspend fun getFixturesStatus(
        timeZone: String,
        fixtureStatusType: String
    ): Response<BaseResponse<SingleFixtureResponse>> {
        return fixturesApiService.getFixturesStatus(timeZone, fixtureStatusType)
    }
    //endregion

    //region HEAD 2 HEAD
    suspend fun getHeadToHead(
        teamsId: String,
        seasonId: Int,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHead(teamsId, seasonId, timeZone)
    }

    suspend fun getHeadToHeadByDate(
        teamsId: String,
        date: String,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByDate(teamsId, date, timeZone)
    }

    suspend fun getHeadToHeadByStatus(
        teamsId: String,
        status: FixtureStatus,
        seasonId: Int,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByStatus(teamsId, status, seasonId, timeZone)
    }

    suspend fun getHeadToHeadByFromAndTo(
        teamsId: String,
        from: String,
        to: String,
        seasonId: Int,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByFromAndTO(teamsId, from, to, seasonId, timeZone)
    }

    suspend fun getHeadToHeadByLeague(
        teamsId: String,
        leagueId: Int,
        seasonId: Int,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByLeague(teamsId, leagueId, seasonId, timeZone)
    }

    suspend fun getHeadToHeadByDateAndLeague(
        teamsId: String,
        leagueId: Int,
        date: String,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByByDateAndLeague(teamsId, leagueId, date, timeZone)
    }

    suspend fun getHeadToHeadByStatusAndLeague(
        teamsId: String,
        leagueId: Int,
        status: FixtureStatus,
        seasonId: Int,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByStatusAndLeague(
            teamsId,
            leagueId,
            status,
            seasonId,
            timeZone
        )
    }

    suspend fun getHeadToHeadByFromAndToAndLeague(
        teamsId: String,
        leagueId: Int,
        from: String,
        to: String,
        seasonId: Int,
        timeZone: String
    ): Response<BaseResponse<HeadToHeadResponse>> {
        return fixturesApiService.getHeadToHeadByFromAndTOAndLeague(
            teamsId,
            leagueId,
            from,
            to,
            seasonId,
            timeZone
        )
    }
    //endregion

    //region STATISTICS
    suspend fun getFixtureStatisticsByFixtureId(
        fixtureId: Int
    ): Response<BaseResponse<FixtureStatisticsDTO>> {
        return fixturesApiService.getFixtureStatisticsByFixtureId(fixtureId)
    }

    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): Response<BaseResponse<FixtureStatisticsDTO>> {
        return fixturesApiService.getFixtureStatisticsByFixtureIdByTeamId(fixtureId, teamId)
    }
    //endregion

    //region EVENTS
    suspend fun getFixtureEventsByFixtureId(fixtureId: Int): Response<BaseResponse<EventDTO>> {
        return fixturesApiService.getFixtureEventsByFixtureId(fixtureId)
    }

    suspend fun getFixtureEventsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): Response<BaseResponse<EventDTO>> {
        return fixturesApiService.getFixtureEventsByFixtureIdByTeamId(fixtureId, teamId)
    }

    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        fixtureId: Int,
        teamId: Int,
        playerId: Int
    ): Response<BaseResponse<EventDTO>> {
        return fixturesApiService.getFixtureEventsByFixtureIdByTeamIdByPlayerId(
            fixtureId,
            teamId,
            playerId
        )
    }

    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
        fixtureEventType: String
    ): Response<BaseResponse<EventDTO>> {
        return fixturesApiService.getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
            fixtureId,
            teamId,
            playerId,
            fixtureEventType
        )
    }
    //endregion

    //region PLAYERS
    suspend fun getFixturePlayersByFixtureId(
        fixtureId: String
    ): Response<BaseResponse<FixturesDTO>> {
        return fixturesApiService.getFixturePlayersByFixtureId(fixtureId)
    }

    suspend fun getFixturePlayersByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): Response<BaseResponse<FixturesDTO>> {
        return fixturesApiService.getFixturePlayersByFixtureIdByTeamId(fixtureId, teamId)
    }
    //endregion

    //region LINEUPS
    suspend fun getFixtureLineupsByFixtureId(
        fixtureId: Int
    ): Response<BaseResponse<LineupDTO>> {
        return fixturesApiService.getFixtureLineupsByFixtureId(fixtureId)
    }

    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): Response<BaseResponse<LineupDTO>> {
        return fixturesApiService.getFixtureLineupsByFixtureIdByTeamId(fixtureId, teamId)
    }

    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        fixtureId: Int,
        playerId: Int
    ): Response<BaseResponse<LineupDTO>> {
        return fixturesApiService.getFixtureLineupsByFixtureIdByPlayerId(fixtureId, playerId)
    }
    //endregion
}