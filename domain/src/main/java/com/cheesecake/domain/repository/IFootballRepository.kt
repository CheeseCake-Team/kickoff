package com.cheesecake.domain.repository

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.FixtureEvents
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.Trophy
import kotlinx.coroutines.flow.Flow

interface IFootballRepository {
    suspend fun getRemoteCountries(): List<Country>

    suspend fun getLocalCountries(): List<Country>

    suspend fun getCountriesSearch(search: String): Flow<List<Country>>

    suspend fun getLeagueNameAndCountry(leagueId: Int, current: Boolean): List<Competition>

    suspend fun getTopScorersInCompetition(leagueId: Int, season: Int): List<PlayerStatistics>

    suspend fun getLocallyLeagueByIdAndSeason(leagueId: Int): Competition?

    suspend fun getSinglePlayerCompact(season: String, teamId: Int): List<PlayerStatistics>

    suspend fun getRemotelyLeagueByIdAndSeason(competitionId: Int, season: String): Competition

    suspend fun updateOrInsertLeague(competition: Competition)

    suspend fun getMatchesByCompetitionIdAndSeason(
        timeZone: String,
        leagueId: Int,
        season: Int
    ): List<Fixture>

    suspend fun deleteLeagueById(leagueId: Int)

    fun getLocallyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<Team>

    suspend fun getRemotelyTeamsByIdAndSeason(leagueId: Int, leagueSeason: Int): List<Team>

    suspend fun updateOrInsertTeams(teamEntities: List<Team>, leagueId: Int, leagueSeason: Int)

    suspend fun updateOrInsertCountries(countries: List<Country>)

    suspend fun getLeaguesByName(leagueName: String): List<Competition>

    suspend fun searchForCompetitions(leagueName: String): List<Competition>

    suspend fun getCompetitionsByCountryName(countryName: String): List<Competition>

    suspend fun searchForTeams(teamName: String): List<Team>

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String?

    suspend fun getTeamStandingByCompetitionIdAndSeason(leagueId: Int, season: Int): List<TeamStanding>

    suspend fun getTeamStatistics(teamId: Int, season: Int, leagueId: Int): TeamStatisticsEntity

    suspend fun getPlayerTrophy(playerId: Int): List<Trophy>

    suspend fun getCoachTrophy(coachId: Int): List<Trophy>

    suspend fun getMatchDetails(
        homeTeamId: Int,
        awayTeamId: Int,
        date: String,
        timeZone: String
    ): Match

    suspend fun getFavoriteTeams(): Flow<List<Team>>

    suspend fun getFavoriteCompetition(): Flow<List<Competition>>

    suspend fun getSquadOfTeam(teamId: Int): List<SquadPlayer>

    suspend fun getTeamMatchesByTeamIdAndSeason(
        timeZone: String,
        season: Int,
        teamId: Int
    ): List<Fixture>

    suspend fun getLocallyTeamById(teamId: Int): Team?

    suspend fun getRemotelyTeam(teamId: Int): Team

    suspend fun updateOrInsertTeam(team: Team, leagueId: Int, season: Int)

    suspend fun getMatchStatisticsByMatchId(fixtureId: Int): List<FixtureStatistics>

    fun getRecentSearches(): Flow<List<RecentSearch>>

    suspend fun updateOrInsertRecentSearch(recent: RecentSearch)

    suspend fun deleteRecentSearchById(recentId: Int)

    suspend fun deleteRecentSearches()

    suspend fun getTeamsByCountryName(countryName: String): List<Team>

    suspend fun getMatchEventByMatchId(fixtureId: Int): List<FixtureEvents>

    suspend fun getPlayerFullStatistics(season: Int, playerId: Int): PlayerStatistics

    suspend fun getPlayerSeasons(): List<Int>

    suspend fun getMatchLineupByMatchId(fixtureId: Int): List<FixtureLineup>

    suspend fun getCompetitions(): List<Competition>

    suspend fun addLeagueList(competitions: List<Competition>)

    suspend fun addTeamsList(triples: List<Triple<Team, Int, Int>>)

    suspend fun readOnboardingState(): Boolean

    suspend fun saveOnboardingState(isCompleted: Boolean)

    fun getSeason(): Flow<String>

    suspend fun setSeason(season: String)

    suspend fun getAllSeasons(): List<String>

    suspend fun getTimezones(): List<String>

    suspend fun setTimezone(timezone: String)

    fun getTimezone(): Flow<String>
}