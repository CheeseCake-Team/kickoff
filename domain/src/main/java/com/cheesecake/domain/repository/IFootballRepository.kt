package com.cheesecake.domain.repository

import com.cheesecake.domain.Entity.League
import com.cheesecake.domain.Entity.Player
import com.cheesecake.domain.Entity.Standings
import com.cheesecake.domain.Entity.TeamInformation
import com.cheesecake.domain.entity.TeamStatisticsEntity

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League>

    suspend fun getLeagueCurrentRound(leagueId: Int, season: Int, current: Boolean): List<String>

    suspend fun getNumberOfTeamsInLeague(leagueId: Int, season: Int): List<TeamInformation>

    suspend fun getLeagueStanding(leagueId: Int, season: Int): List<Standings>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<Player>
    suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsEntity
}