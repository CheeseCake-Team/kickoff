package com.cheesecake.data.repository

import com.cheesecake.data.local.models.mapToDomain
import com.cheesecake.data.local.models.mapToLocal
import com.cheesecake.data.local.models.toLocal
import com.cheesecake.data.repository.models.response.LeagueResponse
import com.cheesecake.data.repository.models.response.mapToDomain
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

    override suspend fun getLeagueCurrentRound(
        leagueId: Int,
        season: Int,
        current: Boolean
    ): List<String> {
        return remoteDataSource.getFixtureRoundsCurrentOnly(season, leagueId, current)
    }

    override suspend fun getLeagueStanding(leagueId: Int, season: Int): List<StandingsEntity> {
        return remoteDataSource.getStandingsByLeagueId(season, leagueId).mapToDomain()
    }

    override suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerEntity> {
        return remoteDataSource.getTopScorers(season, leagueId).mapToDomain()
    }

    override suspend fun getLocallyLeagueByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): LeagueEntity? {
        return localDataSource.getLeagueByIdAndSeason(leagueId, leagueSeason)?.mapRemoteDtoToEntity()
    }

    override suspend fun getRemotelyLeagueByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): LeagueEntity {
        return remoteDataSource.getLeagueByIdAndSeason(leagueId, leagueSeason).first().mapRemoteDtoToEntity()
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
        return localDataSource.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason).mapLocalDtoToEntity()
    }

    override suspend fun getRemotelyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<TeamEntity> {
        return remoteDataSource.getTeamsByLeagueAndSeason(leagueId, leagueSeason).mapRemoteDtoToEntity()
    }

    override suspend fun updateOrInsertTeams(
        teamEntityEntities: List<TeamEntity>,
        leagueId: Int,
        leagueSeason: Int
    ) {
        localDataSource.updateOrInsertTeams(teamEntityEntities.mapToLocal(leagueId, leagueSeason))
    }

    override suspend fun getLeaguesByName(leagueName: String): List<LeagueEntity> {
        return remoteDataSource.getLeaguesByName(leagueName).mapToDomain()
    }

    override suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamsStandingByLeagueIdAndSeason(
        leagueId: Int,
        season: Int
    ): List<TeamEntity> {
        TODO("Not yet implemented")
    }

}