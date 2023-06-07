package com.cheesecake.data.repository


import com.cheesecake.data.repository.mappers.toEntity
import com.cheesecake.data.repository.models.response.mapToDomain
import com.cheesecake.domain.Entity.*
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class IFootballRepositoryImpl
@Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IFootballRepository {



    override suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League> {
        return remoteDataSource.getCurrentSeasonLeague(leagueId, current).mapToDomain()
    }

    override suspend fun getLeagueCurrentRound(leagueId: Int, season: Int, current: Boolean): List<String> {
        return remoteDataSource.getFixtureRoundsCurrentOnly(season, leagueId, current)
    }

    override suspend fun getNumberOfTeamsInLeague(leagueId: Int, season: Int): List<TeamInformation> {
        return remoteDataSource.getTeamsByLeagueAndSeason(leagueId, season).mapToDomain()
    }

    override suspend fun getLeagueStanding(leagueId: Int, season: Int): List<Standings> {
        return remoteDataSource.getStandingsByLeagueId(season,leagueId).mapToDomain()
    }

    override suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<Player> {
        return remoteDataSource.getTopScorers(season, leagueId).mapToDomain()
    }
    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsEntity {
        return remoteDataSource.getTeamStatistics(teamId, season, leagueId).toEntity()
    }
}