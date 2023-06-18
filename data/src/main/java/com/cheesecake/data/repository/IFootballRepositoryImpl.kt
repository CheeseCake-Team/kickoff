package com.cheesecake.data.repository

import android.util.Log
import com.cheesecake.data.repository.mappers.toEntity
import com.cheesecake.data.repository.mappers.toLocal
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.FixtureEvents
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class IFootballRepositoryImpl
@Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IFootballRepository {

    override suspend fun getLeagueNameAndCountry(
        leagueId: Int,
        current: Boolean
    ): List<League> {
        return remoteDataSource.getCurrentSeasonLeague(leagueId, current).toEntity()
    }

    override suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerStatistics> {
        return remoteDataSource.getTopScorers(season, leagueId).toEntity()
    }

    override suspend fun getLocallyLeagueByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): League? {
        return localDataSource.getLeagueByIdAndSeason(leagueId, leagueSeason)
            ?.toEntity()
    }

    override suspend fun getSinglePlayerCompact(
        season: String,
        teamId: Int
    ): List<PlayerStatistics> {
        return remoteDataSource.getPlayerBySeasonByTeamId(season, teamId).toEntity()
    }

    override suspend fun getRemotelyLeagueByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): League {
        return remoteDataSource.getLeagueByIdAndSeason(leagueId, leagueSeason).first()
            .toEntity()
    }

    override suspend fun updateOrInsertLeague(league: League) {
        localDataSource.updateOrInsertLeague(league.toLocal())
    }

    override suspend fun getMatchesByLeagueIdAndSeason(
        timeZone: String,
        leagueId: Int,
        season: Int
    ): List<Fixture> {
        return remoteDataSource.getFixturesBySeasonIdAndLeagueId(timeZone, season, leagueId)
            .toEntity()
    }

    override suspend fun deleteLeagueById(leagueId: Int) {
        localDataSource.deleteLeagueById(leagueId)
    }

    override fun getLocallyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<Team> {
        return localDataSource.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
            .toEntity()
    }

    override suspend fun getRemotelyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<Team> {
        return remoteDataSource.getTeamsByLeagueAndSeason(leagueId, leagueSeason)
            .toEntity()
    }

    override suspend fun updateOrInsertTeams(
        teamEntities: List<Team>,
        leagueId: Int,
        leagueSeason: Int
    ) {
        localDataSource.updateOrInsertTeams(teamEntities.toLocal(leagueId, leagueSeason))
    }

    override suspend fun getLeaguesByName(leagueName: String): List<League> {
        return remoteDataSource.getLeaguesByName(leagueName).toEntity()
    }

    override suspend fun getLeaguesBySearch(leagueName: String): List<League> {
        return remoteDataSource.getLeaguesBySearch(leagueName).toEntity()
    }


    override suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String? {
        return remoteDataSource.getCurrentRoundByLeagueIdAndSeason(leagueId, season, true)
            .firstOrNull()
    }

    override suspend fun getTeamsStandingByLeagueIdAndSeason(
        leagueId: Int,
        season: Int
    ): List<TeamStanding> {
        return remoteDataSource.getStandingsByLeagueId(season, leagueId).toEntity()
    }

    override suspend fun getTeamsBySearch(teamName: String): List<Team> {
        return remoteDataSource.getTeamsBySearch(teamName).toEntity()
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsEntity {
        return remoteDataSource.getTeamStatistics(teamId, season, leagueId).toEntity()
    }

    override suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int
    ): PlayerStatistics {
        return remoteDataSource.getPlayerBySeasonByPlayerId(season, playerId).first().toEntity()
    }

    override suspend fun getPlayerTrophy(playerId: Int): List<Trophy> {
        return remoteDataSource.getPlayerTrophies(playerId).toEntity()
    }

    override suspend fun getFavoriteTeams(): Flow<List<Team>> {
        return localDataSource.getFavouriteTeams().map { it.toEntity() }
    }

    override suspend fun getFavoriteLeagues(): Flow<List<League>> {
        return localDataSource.getFavouriteLeagues().map { it.toEntity() }
    }

    override suspend fun getCoachTrophy(coachId: Int): List<Trophy> {
        return remoteDataSource.getCoachTrophies(coachId).toEntity()
    }
    override suspend fun getFixtureStatisticsByFixtureId(fixtureId: Int): List<FixtureStatistics> {
        return remoteDataSource.getFixtureStatisticsByFixtureId(fixtureId).toEntity()
    }

    override suspend fun getFixtureEventByFixtureId(fixtureId: Int): List<FixtureEvents> {
        return remoteDataSource.getFixtureEventsByFixtureId(fixtureId).toEntity()
    }

    override suspend fun getMatchDetails(teamsId: String, date: String, timeZone: String): Match {
        return remoteDataSource.getHeadToHeadByDate(teamsId, date, timeZone).first().toEntity()
    }
}