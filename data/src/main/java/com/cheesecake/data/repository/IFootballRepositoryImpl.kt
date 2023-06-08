package com.cheesecake.data.repository

import com.cheesecake.data.remote.response.mapToDomain
import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.entity.TeamStandingEntity
import com.cheesecake.data.repository.mappers.toEntity
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.PlayerStatisticsEntity
import com.cheesecake.data.repository.mappers.*
import com.cheesecake.domain.entity.*
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class IFootballRepositoryImpl
@Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    IFootballRepository {

    override suspend fun getLeagueNameAndCountry(
        leagueId: Int,
        current: Boolean
    ): List<LeagueEntity> {
        return remoteDataSource.getCurrentSeasonLeague(leagueId, current).mapRemoteDtoToEntity()
    }

    override suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerStatisticsEntity> {
        return remoteDataSource.getTopScorers(season, leagueId).mapToEntity()
    }

    override suspend fun getLocallyLeagueByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): LeagueEntity? {
        return localDataSource.getLeagueByIdAndSeason(leagueId, leagueSeason)
            ?.mapRemoteDtoToEntity()
    }

    override suspend fun getSinglePlayerCompact(season: String, teamId: Int): List<PlayerStatisticsEntity> {
        return remoteDataSource.getPlayerBySeasonByTeamId(season, teamId).mapToEntity()
    }

    override suspend fun getRemotelyLeagueByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): LeagueEntity {
        return remoteDataSource.getLeagueByIdAndSeason(leagueId, leagueSeason).first()
            .mapRemoteDtoToEntity()
    }

    override suspend fun updateOrInsertLeague(leagueEntity: LeagueEntity) {
        localDataSource.updateOrInsertLeague(leagueEntity.toLocal())
    }

    override suspend fun getMatchesByLeagueIdAndSeason(
        timeZone: String,
        leagueId: Int,
        Season: String
    ): List<FixtureEntity> {
        return remoteDataSource.getFixturesBySeasonIdAndLeagueId(timeZone, Season, leagueId)
            .mapToDomain()
    }

    override suspend fun deleteLeagueById(leagueId: Int) {
        localDataSource.deleteLeagueById(leagueId)
    }

    override fun getLocallyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<TeamEntity> {
        return localDataSource.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
            .mapLocalDtoToEntity()
    }

    override suspend fun getRemotelyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<TeamEntity> {
        return remoteDataSource.getTeamsByLeagueAndSeason(leagueId, leagueSeason)
            .mapRemoteDtoToEntity()
    }

    override suspend fun updateOrInsertTeams(
        teamEntityEntities: List<TeamEntity>,
        leagueId: Int,
        leagueSeason: Int
    ) {
        localDataSource.updateOrInsertTeams(teamEntityEntities.mapToLocal(leagueId, leagueSeason))
    }

    override suspend fun getLeaguesByName(leagueName: String): List<LeagueEntity> {
        return remoteDataSource.getLeaguesByName(leagueName).mapRemoteDtoToEntity()
    }


    override suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String? {
        return remoteDataSource.getCurrentRoundByLeagueIdAndSeason(leagueId, season, true).firstOrNull()
    }

    override suspend fun getTeamsStandingByLeagueIdAndSeason(
        leagueId: Int,
        season: Int
    ): List<TeamStandingEntity> {
        return remoteDataSource.getStandingsByLeagueId(season, leagueId).mapRemoteDtoToEntity()
    }

    override suspend fun getTeamsByName(teamName: String): List<TeamEntity> {
        return remoteDataSource.getTeamsByName(teamName).mapRemoteDtoToEntity()
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsEntity {
        return remoteDataSource.getTeamStatistics(teamId, season, leagueId).toEntity()
    }
    override suspend fun getPlayerBySeasonByPlayerId(season: String, playerId: Int): PlayerStatisticsEntity {
        return remoteDataSource.getPlayerBySeasonByPlayerId(season, playerId).first().mapToEntity()
    }

    override suspend fun getPlayerTrophy(playerId: Int): List<TrophyEntity> {
        return remoteDataSource.getPlayerTrophies(playerId).mapToEntity()
    }

    override suspend fun getCoachTrophy(coachId: Int): List<TrophyEntity> {
        return remoteDataSource.getCoachTrophies(coachId).mapToEntity()
    }
}