package com.cheesecake.domain.repository

import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.TeamStandingEntity
import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.entity.PlayerStatisticsEntity

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<LeagueEntity>

    suspend fun getLeagueStanding(leagueId: Int, season: Int): List<TeamStandingEntity>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerStatisticsEntity>

    suspend fun getLocallyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueEntity?

    suspend fun getSinglePlayerCompact(season: String, teamId: Int): List<PlayerStatisticsEntity>

    suspend fun getRemotelyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueEntity

    suspend fun updateOrInsertLeague(leagueEntity: LeagueEntity)

    suspend fun getMatchesByLeagueIdAndSeason(
        timeZone: String,
        leagueId: Int,
        Season: String
    ): List<FixtureEntity>

    suspend fun deleteLeagueById(leagueId: Int)

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<TeamEntity>

    suspend fun getRemotelyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<TeamEntity>

    suspend fun updateOrInsertTeams(
        teamEntityEntities: List<TeamEntity>,
        leagueId: Int,
        leagueSeason: Int
    )

    suspend fun getLeaguesByName(leagueName: String): List<LeagueEntity>

    suspend fun getTeamsByName(teamName: String): List<TeamEntity>

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String?

    suspend fun getTeamsStandingByLeagueIdAndSeason(leagueId: Int, season: Int): List<TeamStandingEntity>

    suspend fun getTeamStatistics(teamId: Int, season: Int, leagueId: Int): TeamStatisticsEntity

    suspend fun getPlayerBySeasonByPlayerId(season: String, playerId: Int): PlayerStatisticsEntity
}
