package com.cheesecake.domain.repository

import com.cheesecake.domain.models.League
import com.cheesecake.domain.models.PlayerStatisticsEntity
import com.cheesecake.domain.models.Standings
import com.cheesecake.domain.models.TeamInformation

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League>

    suspend fun getLeagueCurrentRound(leagueId: Int, season: Int, current: Boolean): List<String>

    suspend fun getNumberOfTeamsInLeague(leagueId: Int, season: Int): List<TeamInformation>

    suspend fun getLeagueStanding(leagueId: Int, season: Int): List<Standings>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerStatisticsEntity>

    suspend fun getLocallyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): League?

    suspend fun getRemotelyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): League?

    suspend fun updateOrInsertLeague(league: League)

    suspend fun deleteLeagueById(leagueId: Int)

    suspend fun getPlayerBySeasonByPlayerId(season: String,playerId: Int) : PlayerStatisticsEntity


}