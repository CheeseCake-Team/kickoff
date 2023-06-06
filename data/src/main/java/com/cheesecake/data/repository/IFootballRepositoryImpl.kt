package com.cheesecake.data.repository


import com.cheesecake.data.local.LocalDataSource
import com.cheesecake.data.models.dto.mapToDomain
import com.cheesecake.data.remote.RemoteDataSource
import com.cheesecake.domain.models.*
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class IFootballRepositoryImpl
@Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ):
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
}