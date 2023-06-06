package com.cheesecake.domain.repository

import com.cheesecake.domain.models.League
import com.cheesecake.domain.models.Player
import com.cheesecake.domain.models.Standings
import com.cheesecake.domain.models.TeamInformation

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League>

    suspend fun getLeagueCurrentRound(leagueId: Int, season: Int, current: Boolean): List<String>

    suspend fun getNumberOfTeamsInLeague(leagueId: Int, season: Int): List<TeamInformation>

    suspend fun getLeagueStanding(leagueId: Int, season: Int): List<Standings>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<Player>
}