package com.cheesecake.data.repository

import com.cheesecake.data.models.dto.LeagueDTO
import com.cheesecake.data.models.dto.PlayerDTO
import com.cheesecake.data.models.dto.StandingsDTO
import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.remote.RemoteDataSource
import javax.inject.Inject

class Repository@Inject constructor(private val remoteDataSource: RemoteDataSource){

    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean) : List<LeagueDTO>{
        return remoteDataSource.getCurrentSeasonLeague(leagueId, current)
    }

    suspend fun getLeagueCurrentRound(leagueId: Int, season: Int, current: Boolean): List<String>{
        return remoteDataSource.getFixtureRoundsCurrentOnly(season,leagueId,current)
    }

    suspend fun getNumberOfTeamsInLeague(leagueId: Int, season: Int): List<TeamInformationDTO> {
        return remoteDataSource.getTeamsByLeagueAndSeason(leagueId, season)
    }

    suspend fun getLeagueStanding(leagueId: Int, season: Int): List<StandingsDTO>{
        return remoteDataSource.getStandingsByLeagueId(season, leagueId)
    }

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerDTO>{
        return remoteDataSource.getTopScorers(season, leagueId)
    }
}