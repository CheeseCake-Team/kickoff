package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ManageTeamsUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {
    /**
     * @author Nahla
     * */
    suspend fun getTeamById(teamId: Int): Team {
        return footballRepository.getLocallyTeamById(teamId) ?: footballRepository.getRemotelyTeam(
            teamId
        )
    }

    /**
     * @author Abdurrahman & Najeia
     * */
    suspend fun getCompetitionTeams(competitions: List<League>): List<Triple<List<Team>, Int, Int>> {
        return competitions.map { league ->
            Triple(
                footballRepository.getRemotelyTeamsByIdAndSeason(
                    league.leagueId,
                    league.season.last()
                ), league.leagueId, league.season.last()
            )
        }
    }

    /**
     * @author Anwar
     * */
    suspend fun getTeamStatistics(
        competitionId: Int,
        season: Int,
        teamId: Int
    ): TeamStatisticsEntity {
        return footballRepository.getTeamStatistics(teamId, season, competitionId)
    }

    /**
     * @author Shehab
     * */
    suspend fun searchForTeams(teamName: String): List<Team> {
        return footballRepository.searchForTeams(teamName)
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getTeamsByCountryName(countryName: String): List<Team> =
        footballRepository.getTeamsByCountryName(countryName)

    /**
     * @author Abdurrahman & Nahla
     * */
    suspend fun getFavoriteTeams(): Flow<List<Team>> {
        return footballRepository.getFavoriteTeams()
    }

    /**
     * @author Nahla
     * */
    suspend fun getCompetitionTeams(competitionId: Int, competitionSeason: Int): List<Team> =
        footballRepository.getRemotelyTeamsByIdAndSeason(competitionId, competitionSeason)

    /**
     * @author Nahla
     * */
    suspend fun favoriteTeam(teamId: Int): Team {
        getTeamById(teamId).let {
            footballRepository.updateOrInsertTeam(
                Team(
                    id = it.id,
                    name = it.name,
                    yearFounded = it.yearFounded,
                    country = it.country,
                    stadiumCapacity = it.stadiumCapacity,
                    stadiumName = it.stadiumName,
                    imageUrl = it.imageUrl,
                    isFavourite = !it.isFavourite,
                ),
                39, 2022
            )
        }
        return getTeamById(teamId)
    }

    private val selectedTeams: MutableList<Triple<Team, Int, Int>> = mutableListOf()

    /**
     * @author Abdurrahman & Najeia
     * */
    fun toggleTeamFavoriteStatus(team: Team, leagueId: Int, season: Int) {
        selectedTeams.find { it.first == team }?.let { (team, leagueId, season) ->
            selectedTeams.remove(Triple(team.copy(isFavourite = false), leagueId, season))
        } ?: run {
            selectedTeams.add(Triple(team.copy(isFavourite = true), leagueId, season))
        }
    }

    /**
     * @author Abdurrahman & Najeia
     * */
    suspend fun saveSelectedTeams(): Boolean {
        val triples = selectedTeams.toList()
        footballRepository.addTeamsList(triples)
        return true
    }

    /**
     * @author Mujtaba
     * */
    suspend fun getTeamStandingByCompetitionIdAndSeason(
        competitionId: Int,
        season: Int
    ): List<TeamStanding> {
        return footballRepository.getTeamStandingByCompetitionIdAndSeason(competitionId, season)
    }
}