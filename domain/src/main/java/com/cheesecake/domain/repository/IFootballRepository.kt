package com.cheesecake.domain.repository

import com.cheesecake.domain.entity.PlayerEntity
import com.cheesecake.domain.entity.TeamStandingEntity
import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.entity.TeamEntity

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<LeagueEntity>

    suspend fun getLeagueStanding(leagueId: Int, season: Int): List<TeamStandingEntity>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerEntity>

    suspend fun getLocallyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueEntity?

    suspend fun getRemotelyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueEntity?

    suspend fun updateOrInsertLeague(leagueEntity: LeagueEntity)

    suspend fun getMatchesByLeagueIdAndSeason(timeZone: String, leagueId: Int, Season: String): List<FixtureEntity>

    suspend fun deleteLeagueById(leagueId: Int)

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<TeamEntity>

    suspend fun getRemotelyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<TeamEntity>

    suspend fun updateOrInsertTeams(teamEntityEntities: List<TeamEntity>, leagueId: Int, leagueSeason: Int)

    suspend fun getLeaguesByName(leagueName: String): List<LeagueEntity>

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String?

    suspend fun getTeamsStandingByLeagueIdAndSeason(leagueId: Int, season: Int): List<TeamStandingEntity>

}