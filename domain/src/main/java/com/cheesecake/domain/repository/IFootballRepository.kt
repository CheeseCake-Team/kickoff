package com.cheesecake.domain.repository

import com.cheesecake.domain.Entity.League
import com.cheesecake.domain.Entity.Player
import com.cheesecake.domain.Entity.Standings
import com.cheesecake.domain.Entity.TeamInformation
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.PlayerEntity
import com.cheesecake.domain.entity.TeamStandingEntity
import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.entity.TeamEntity

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League>

    suspend fun getLeaguesByName(leagueName: String): List<LeagueEntity>

    suspend fun getTeamsByName(teamName: String): List<TeamEntity>

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<Player>
    suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsEntity
    suspend fun getTeamsStandingByLeagueIdAndSeason(leagueId: Int, season: Int): List<TeamStandingEntity>

    suspend fun getSinglePlayerCompact(season: String, teamId: Int):List<PlayerEntity>

}