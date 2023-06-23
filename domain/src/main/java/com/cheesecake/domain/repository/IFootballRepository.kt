package com.cheesecake.domain.repository

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.FixtureEvents
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.entity.Player
import com.cheesecake.domain.entity.RecentSearch
import kotlinx.coroutines.flow.Flow

interface IFootballRepository {

    suspend fun getRemoteCountries():List<Country>

    suspend fun getLocalCountries() : List<Country>

    suspend fun getCountriesSearch(search: String): Flow<List<Country>>

    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<League>

    suspend fun getLeagueTopScorers(leagueId: Int, season: Int): List<PlayerStatistics>

    suspend fun getLocallyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): League?

    suspend fun getSinglePlayerCompact(season: String, teamId: Int): List<PlayerStatistics>

    suspend fun getRemotelyLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): League

    suspend fun updateOrInsertLeague(league: League)

    suspend fun getMatchesByLeagueIdAndSeason(timeZone: String, leagueId: Int, season: Int): List<Fixture>

    suspend fun deleteLeagueById(leagueId: Int)

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<Team>

    suspend fun getRemotelyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<Team>

    suspend fun updateOrInsertTeams(teamEntities: List<Team>, leagueId: Int, leagueSeason: Int)

    suspend fun updateOrInsertCountries(countries: List<Country>)

    suspend fun getLeaguesByName(leagueName: String): List<League>

    suspend fun getLeaguesBySearch(leagueName: String): List<League>

    suspend fun getLeaguesByCountryName(countryName: String): List<League>

    suspend fun getTeamsBySearch(teamName: String): List<Team>

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String?

    suspend fun getTeamsStandingByLeagueIdAndSeason(leagueId: Int, season: Int): List<TeamStanding>

    suspend fun getTeamStatistics(teamId: Int, season: Int, leagueId: Int): TeamStatisticsEntity

    suspend fun getPlayerBySeasonByPlayerId(season: String, playerId: Int): PlayerStatistics

    suspend fun getPlayerTrophy(playerId: Int): List<Trophy>

    suspend fun getCoachTrophy(coachId: Int): List<Trophy>

    suspend fun getMatchDetails(teamsId: String, date: String, timeZone: String): Match

    suspend fun getFavoriteTeams(): Flow<List<Team>>

    suspend fun getFavoriteLeagues(): Flow<List<League>>

    suspend fun getSquadOfTeam(teamId: Int): List<SquadPlayer>

    suspend fun getMatchesByTeamIdAndSeason(
        timeZone: String,
        season: Int,
        teamId: Int
    ): List<Fixture>

    suspend fun getLocallyTeamById(teamId: Int): Team?

    suspend fun getRemotelyTeam(teamId: Int): Team

    suspend fun updateOrInsertTeam(team: Team, leagueId: Int, season: Int)
    suspend fun getFixtureStatisticsByFixtureId(fixtureId: Int): List<FixtureStatistics>

    fun getRecentSearches(): Flow<List<RecentSearch>>

    suspend fun updateOrInsertRecentSearch(recent: RecentSearch)

    suspend fun deleteRecentSearchById(recentId: Int)

    suspend fun deleteRecentSearches()

    suspend fun getTeamsByCountryName(countryName: String): List<Team>

    suspend fun getFixtureEventByFixtureId(fixtureId: Int): List<FixtureEvents>

    suspend fun getPlayerSingle(seasonId: Int, playerId: Int): Player

    suspend fun getPlayerFullStatistics(seasonId: Int, playerId: Int): PlayerStatistics

    suspend fun getFixtureLineupByFixtureId(fixtureId: Int): List<FixtureLineup>
}
