package com.cheesecake.data.repository

import com.cheesecake.data.repository.mappers.toEntity
import com.cheesecake.data.repository.mappers.toLocal
import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.FixtureEvents
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import toEntity
import javax.inject.Inject

class IFootballRepositoryImpl
@Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val onboardingDataSource: OnboardingDataSource,
) : IFootballRepository {
    override suspend fun getRemoteCountries(): List<Country> {
        return remoteDataSource.getCountries().toEntity()
    }

    override suspend fun getLocalCountries(): List<Country> {
        return localDataSource.getLocalCountries().toEntity()
    }

    override suspend fun getCountriesSearch(search: String): Flow<List<Country>> {
        return localDataSource.getCountriesSearch(search).toEntity()
    }

    override suspend fun getLeagueNameAndCountry(
        leagueId: Int,
        current: Boolean
    ): List<League> {
        return remoteDataSource.getCurrentSeasonLeague(leagueId, current).toEntity()
    }

    override suspend fun getTopScorersInCompetition(leagueId: Int, season: Int): List<PlayerStatistics> {
        return remoteDataSource.getTopScorers(season, leagueId).toEntity()
    }

    override suspend fun getLocallyLeagueByIdAndSeason(
        leagueId: Int,
    ): League? {
        return localDataSource.getLeagueByIdAndSeason(leagueId)
            ?.toEntity()
    }

    override suspend fun getSinglePlayerCompact(
        season: String,
        teamId: Int
    ): List<PlayerStatistics> {
        return remoteDataSource.getPlayerBySeasonByTeamId(season, teamId).toEntity()
    }

    override suspend fun getRemotelyLeagueByIdAndSeason(
        competitionId: Int,
        season: String
    ): League {
        return remoteDataSource.getCompetitionByIdAndSeason(competitionId, season).first()
            .toEntity()
    }

    override suspend fun updateOrInsertLeague(league: League) {
        localDataSource.updateOrInsertLeague(league.toLocal())
    }

    override suspend fun getMatchesByCompetitionIdAndSeason(
        timeZone: String,
        leagueId: Int,
        season: Int
    ): List<Fixture> {
        return remoteDataSource.getFixturesBySeasonIdAndLeagueId(timeZone, season, leagueId)
            .toEntity()
    }

    override suspend fun deleteLeagueById(leagueId: Int) {
        localDataSource.deleteLeagueById(leagueId)
    }

    override fun getLocallyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<Team> {
        return localDataSource.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
            .toEntity()
    }

    override suspend fun getRemotelyTeamsByIdAndSeason(
        leagueId: Int,
        leagueSeason: Int
    ): List<Team> {
        return remoteDataSource.getTeamsByLeagueAndSeason(leagueId, leagueSeason)
            .toEntity()
    }

    override suspend fun updateOrInsertTeams(
        teamEntities: List<Team>,
        leagueId: Int,
        leagueSeason: Int
    ) {
        localDataSource.updateOrInsertTeams(teamEntities.toLocal(leagueId, leagueSeason))
    }

    override suspend fun updateOrInsertCountries(countries: List<Country>) {
        localDataSource.addTeamCountries(countries.toLocal())
    }

    override suspend fun getLeaguesByName(leagueName: String): List<League> {
        return remoteDataSource.getLeaguesByName(leagueName).toEntity()
    }

    override suspend fun searchForCompetitions(leagueName: String): List<League> {
        return remoteDataSource.getLeaguesBySearch(leagueName).toEntity()
    }

    override suspend fun getCompetitionsByCountryName(countryName: String): List<League> {
        return remoteDataSource.getLeaguesByCountryName(countryName).toEntity()
    }

    override suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String? {
        return remoteDataSource.getCurrentRoundByLeagueIdAndSeason(leagueId, season, true)
            .firstOrNull()
    }

    override suspend fun getTeamStandingByCompetitionIdAndSeason(
        leagueId: Int,
        season: Int
    ): List<TeamStanding> {
        return remoteDataSource.getStandingsByLeagueId(season, leagueId).toEntity()
    }

    override suspend fun searchForTeams(teamName: String): List<Team> {
        return remoteDataSource.getTeamsBySearch(teamName).toEntity()
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsEntity {
        return remoteDataSource.getTeamStatistics(teamId, season, leagueId).toEntity()
    }

    override suspend fun getPlayerTrophy(playerId: Int): List<Trophy> {
        return remoteDataSource.getPlayerTrophies(playerId).toEntity()
    }

    override suspend fun getFavoriteTeams(): Flow<List<Team>> {
        return localDataSource.getFavouriteTeams().map { it.toEntity() }
    }

    override suspend fun getFavoriteCompetition(): Flow<List<League>> {
        return localDataSource.getFavouriteLeagues().map { it.toEntity() }
    }

    override suspend fun getCoachTrophy(coachId: Int): List<Trophy> {
        return remoteDataSource.getCoachTrophies(coachId).toEntity()
    }

    override suspend fun getCompetitions(): List<League> {
        return remoteDataSource.getAllLeagues().toEntity()
    }

    override suspend fun addLeagueList(leagues: List<League>) {
        localDataSource.addLeaguesList(leagues.map { it.toLocal() })
    }

    override suspend fun readOnboardingState(): Boolean {
        return onboardingDataSource.readOnboardingState()
    }

    override suspend fun saveOnboardingState(isCompleted: Boolean) {
        onboardingDataSource.saveOnboardingState(isCompleted)
    }

    override fun getSeason(): Flow<String> {
        return localDataSource.getSeason()
    }

    override suspend fun setSeason(season: String) {
        localDataSource.setSeason(season)
    }

    override suspend fun getAllSeasons(): List<String> {
        return remoteDataSource.getAllSeasons()
    }

    override suspend fun getTimezones(): List<String> {
        return remoteDataSource.getTimezones()
    }

    override suspend fun setTimezone(timezone: String) {
        localDataSource.setTimezone(timezone)
    }

    override fun getTimezone(): Flow<String> {
        return localDataSource.getTimezone()
    }

    override suspend fun getMatchStatisticsByMatchId(fixtureId: Int): List<FixtureStatistics> {
        return remoteDataSource.getFixtureStatisticsByFixtureId(fixtureId).toEntity()
    }

    override suspend fun getTeamsByCountryName(countryName: String): List<Team> {
        return remoteDataSource.getTeamsByCountryName(countryName).toEntity()
    }

    override suspend fun getMatchEventByMatchId(fixtureId: Int): List<FixtureEvents> {
        return remoteDataSource.getFixtureEventsByFixtureId(fixtureId).toEntity()
    }

    override suspend fun getMatchDetails(
        homeTeamId: Int,
        awayTeamId: Int,
        date: String,
        timeZone: String
    ): Match {
        return remoteDataSource.getHeadToHeadByDate("$homeTeamId-$awayTeamId", date, timeZone)
            .first().toEntity()
    }


    override suspend fun getSquadOfTeam(teamId: Int): List<SquadPlayer> {
        return remoteDataSource.getSquadByTeamId(teamId).toEntity()
    }

    override suspend fun getTeamMatchesByTeamIdAndSeason(
        timeZone: String,
        season: Int,
        teamId: Int
    ): List<Fixture> {
        return remoteDataSource.getFixtureBySeasonByTeamId(timeZone, season, teamId).toEntity()
    }

    override suspend fun getRemotelyTeam(teamId: Int): Team {
        return remoteDataSource.getTeamById(teamId).first().toEntity()
    }

    override suspend fun updateOrInsertTeam(team: Team, leagueId: Int, season: Int) {
        return localDataSource.updateOrInsertTeam(team.toLocal(leagueId, season))
    }

    override suspend fun getMatchLineupByMatchId(fixtureId: Int): List<FixtureLineup> {
        return remoteDataSource.getFixtureLineupsByFixtureId(fixtureId).toEntity()
    }

    override suspend fun getLocallyTeamById(teamId: Int): Team? {
        return localDataSource.getTeamById(teamId)?.toEntity()
    }


    override fun getRecentSearches(): Flow<List<RecentSearch>> {
        return localDataSource.getRecentSearches().map { list -> list.map { it.toEntity() } }
    }

    override suspend fun updateOrInsertRecentSearch(recent: RecentSearch) {
        localDataSource.updateOrInsertRecentSearches(recent.toLocal())
    }

    override suspend fun deleteRecentSearchById(recentId: Int) {
        localDataSource.deleteRecentSearchById(recentId)
    }

    override suspend fun deleteRecentSearches() {
        localDataSource.deleteRecentSearches()
    }

    override suspend fun addTeamsList(triples: List<Triple<Team, Int, Int>>) {
        triples.map { triple ->
            triple.first.toLocal(triple.second, triple.third)
        }.also {
            localDataSource.addTeamsList(it)
        }
    }

    override suspend fun getPlayerFullStatistics(
        season: Int,
        playerId: Int
    ): PlayerStatistics {
        return remoteDataSource.getPlayerBySeasonByPlayerId(season, playerId)
            .first().toEntity()
    }

    override suspend fun getPlayerSeasons(): List<Int> {
        return remoteDataSource.getPlayerSeasons()
    }
}