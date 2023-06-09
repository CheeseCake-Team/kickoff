package com.cheesecake.domain.repository

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.Trophy

interface IFootballRepository {
    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerStatistics>

    suspend fun getLocallyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): League?

    suspend fun getSinglePlayerCompact(season: String, teamId: Int): List<PlayerStatistics>

    suspend fun getRemotelyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): League

    suspend fun updateOrInsertLeague(league: League)

    suspend fun getMatchesByLeagueIdAndSeason(timeZone: String, leagueId: Int, Season: Int): List<Fixture>

    suspend fun deleteLeagueById(leagueId: Int)

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<Team>

    suspend fun getRemotelyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<Team>

    suspend fun updateOrInsertTeams(
        teamEntities: List<Team>, leagueId: Int, leagueSeason: Int
    )

    suspend fun getLeaguesByName(leagueName: String): List<League>

    suspend fun getTeamsByName(teamName: String): List<Team>

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String?

    suspend fun getTeamsStandingByLeagueIdAndSeason(
        leagueId: Int,
        season: Int
    ): List<TeamStanding>

    suspend fun getTeamStatistics(teamId: Int, season: Int, leagueId: Int): TeamStatisticsEntity

    suspend fun getPlayerBySeasonByPlayerId(season: String, playerId: Int): PlayerStatistics

    suspend fun getPlayerTrophy(playerId: Int): List<Trophy>
    suspend fun getCoachTrophy(coachId: Int): List<Trophy>
}
