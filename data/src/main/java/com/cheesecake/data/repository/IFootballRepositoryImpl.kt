package com.cheesecake.data.repository


import com.cheesecake.data.remote.response.mapToDomain
import com.cheesecake.data.repository.mappers.mapLocalDtoToEntity
import com.cheesecake.data.repository.mappers.mapRemoteDtoToEntity
import com.cheesecake.data.repository.mappers.mapToLocal
import com.cheesecake.data.repository.mappers.toLocal
import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.entity.PlayerEntity
import com.cheesecake.domain.entity.StandingsEntity
import com.cheesecake.domain.entity.TeamEntity
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

    override suspend fun getAllLeagues(): List<LeagueEntity> {
        return remoteDataSource.getAllLeagues().mapRemoteDtoToEntity()
    }

}