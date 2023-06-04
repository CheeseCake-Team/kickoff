package com.cheesecake.data.repository.fixture

import com.cheesecake.data.remote.RemoteDataSource
import com.cheesecake.data.remote.response.FixtureResponse
import javax.inject.Inject

class FixturesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : FixturesRepository {


    override suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<FixtureResponse> {
        return remoteDataSource.getFixtureById(timeZone, fixtureId)
    }

//    //region ROUNDS
//    suspend fun getFixtureRounds(seasonId: Int, leagueId: Int): Response<BaseResponse<String>> {
//        return remoteDataSource.getFixtureRounds(seasonId, leagueId)
//    }
//
//    suspend fun getFixtureRoundsCurrentOnly(
//        seasonId: Int,
//        leagueId: Int,
//        current: Boolean
//    ): Response<BaseResponse<String>> {
//        return remoteDataSource.getFixtureRoundsCurrentOnly(seasonId, leagueId, current)
//    }
//
//    //endregion
//
//    //region FIXTURES
//    suspend fun getFixtureById(
//        timeZone: String,
//        fixtureId: Int
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixtureById(timeZone, fixtureId)
//    }
//
//    suspend fun getFixturesBySeasonIdByTeamId(
//        timeZone: String,
//        season: String,
//        teamId: Int
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixturesBySeasonIdByTeamId(timeZone, season, teamId)
//    }
//
//    suspend fun getFixturesByDate(
//        timeZone: String,
//        date: String
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixturesByDate(timeZone, date)
//    }
//
//    suspend fun getFixturesFromDate(
//        timeZone: String,
//        date: String
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixturesFromDate(timeZone, date)
//    }
//
//    suspend fun getFixturesToDate(
//        timeZone: String,
//        date: String
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixturesToDate(timeZone, date)
//    }
//
//    suspend fun getFixturesFromDateToDate(
//        timeZone: String,
//        season: String,
//        teamId: Int,
//        from: String,
//        to: String
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixturesFromDateToDate(timeZone, season, teamId, from, to)
//    }
//
//    suspend fun getFixturesStatus(
//        timeZone: String,
//        fixtureStatusType: String
//    ): Response<BaseResponse<FixtureResponse>> {
//        return remoteDataSource.getFixturesStatus(timeZone, fixtureStatusType)
//    }
//    //endregion
//
//    //region HEAD 2 HEAD
//    suspend fun getHeadToHead(
//        teamsId: String,
//        seasonId: Int,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHead(teamsId, seasonId, timeZone)
//    }
//
//    suspend fun getHeadToHeadByDate(
//        teamsId: String,
//        date: String,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByDate(teamsId, date, timeZone)
//    }
//
//    suspend fun getHeadToHeadByStatus(
//        teamsId: String,
//        status: FixtureStatus,
//        seasonId: Int,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByStatus(teamsId, status, seasonId, timeZone)
//    }
//
//    suspend fun getHeadToHeadByFromAndTo(
//        teamsId: String,
//        from: String,
//        to: String,
//        seasonId: Int,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByFromAndTO(teamsId, from, to, seasonId, timeZone)
//    }
//
//    suspend fun getHeadToHeadByLeague(
//        teamsId: String,
//        leagueId: Int,
//        seasonId: Int,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByLeague(teamsId, leagueId, seasonId, timeZone)
//    }
//
//    suspend fun getHeadToHeadByDateAndLeague(
//        teamsId: String,
//        leagueId: Int,
//        date: String,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByByDateAndLeague(teamsId, leagueId, date, timeZone)
//    }
//
//    suspend fun getHeadToHeadByStatusAndLeague(
//        teamsId: String,
//        leagueId: Int,
//        status: FixtureStatus,
//        seasonId: Int,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByStatusAndLeague(
//            teamsId,
//            leagueId,
//            status,
//            seasonId,
//            timeZone
//        )
//    }
//
//    suspend fun getHeadToHeadByFromAndToAndLeague(
//        teamsId: String,
//        leagueId: Int,
//        from: String,
//        to: String,
//        seasonId: Int,
//        timeZone: String
//    ): Response<BaseResponse<HeadToHeadDTO>> {
//        return remoteDataSource.getHeadToHeadByFromAndTOAndLeague(
//            teamsId,
//            leagueId,
//            from,
//            to,
//            seasonId,
//            timeZone
//        )
//    }
//    //endregion
//
//    //region STATISTICS
//    suspend fun getFixtureStatisticsByFixtureId(
//        fixtureId: Int
//    ): Response<BaseResponse<FixtureStatisticsDTO>> {
//        return remoteDataSource.getFixtureStatisticsByFixtureId(fixtureId)
//    }
//
//    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
//        fixtureId: Int,
//        teamId: Int
//    ): Response<BaseResponse<FixtureStatisticsDTO>> {
//        return remoteDataSource.getFixtureStatisticsByFixtureIdByTeamId(fixtureId, teamId)
//    }
//    //endregion
//
//    //region EVENTS
//    suspend fun getFixtureEventsByFixtureId(fixtureId: Int): Response<BaseResponse<EventDTO>> {
//        return remoteDataSource.getFixtureEventsByFixtureId(fixtureId)
//    }
//
//    suspend fun getFixtureEventsByFixtureIdByTeamId(
//        fixtureId: Int,
//        teamId: Int
//    ): Response<BaseResponse<EventDTO>> {
//        return remoteDataSource.getFixtureEventsByFixtureIdByTeamId(fixtureId, teamId)
//    }
//
//    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
//        fixtureId: Int,
//        teamId: Int,
//        playerId: Int
//    ): Response<BaseResponse<EventDTO>> {
//        return remoteDataSource.getFixtureEventsByFixtureIdByTeamIdByPlayerId(
//            fixtureId,
//            teamId,
//            playerId
//        )
//    }
//
//    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
//        fixtureId: Int,
//        teamId: Int,
//        playerId: Int,
//        fixtureEventType: String
//    ): Response<BaseResponse<EventDTO>> {
//        return remoteDataSource.getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
//            fixtureId,
//            teamId,
//            playerId,
//            fixtureEventType
//        )
//    }
//    //endregion
//
//    //region PLAYERS
//    suspend fun getFixturePlayersByFixtureId(
//        fixtureId: String
//    ): Response<BaseResponse<FixturesDTO>> {
//        return remoteDataSource.getFixturePlayersByFixtureId(fixtureId)
//    }
//
//    suspend fun getFixturePlayersByFixtureIdByTeamId(
//        fixtureId: Int,
//        teamId: Int
//    ): Response<BaseResponse<FixturesDTO>> {
//        return remoteDataSource.getFixturePlayersByFixtureIdByTeamId(fixtureId, teamId)
//    }
//    //endregion
//
//    //region LINEUPS
//    suspend fun getFixtureLineupsByFixtureId(
//        fixtureId: Int
//    ): Response<BaseResponse<LineupDTO>> {
//        return remoteDataSource.getFixtureLineupsByFixtureId(fixtureId)
//    }
//
//    suspend fun getFixtureLineupsByFixtureIdByTeamId(
//        fixtureId: Int,
//        teamId: Int
//    ): Response<BaseResponse<LineupDTO>> {
//        return remoteDataSource.getFixtureLineupsByFixtureIdByTeamId(fixtureId, teamId)
//    }
//
//    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
//        fixtureId: Int,
//        playerId: Int
//    ): Response<BaseResponse<LineupDTO>> {
//        return remoteDataSource.getFixtureLineupsByFixtureIdByPlayerId(fixtureId, playerId)
//    }
//    //endregion
}