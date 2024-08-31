package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ManageCompetitionsUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {
    /**
     * @author Najeia
     * */
    suspend fun getCompetitions(): List<League> {
        val competitions = footballRepository.getCompetitions()
        return competitions.shuffled()
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getCompetitionsByCountryName(countryName: String): List<League> =
        footballRepository.getCompetitionsByCountryName(countryName)

    /**
     * @author Shehab
     * */
    suspend fun getCompetitionByIdAndSeason(competitionId: Int, season: String): League {
        return footballRepository.getRemotelyLeagueByIdAndSeason(competitionId, season)
    }

    /**
     * @author Shehab
     * */
    suspend fun searchForCompetitions(competitionName: String): List<League> {
        return footballRepository.searchForCompetitions(competitionName)
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getFavoriteCompetition(): Flow<List<League>> =
        footballRepository.getFavoriteCompetition()

    private val selectedCompetitions: MutableList<League> = mutableListOf()

    /**
     * @author Abdurrahman & Najeia
     * */
    fun addCompetition(competition: League) {
        selectedCompetitions.find { it.competitionId == competition.competitionId }?.let {
            selectedCompetitions.removeIf { it.competitionId == competition.competitionId }
        } ?: run {
            selectedCompetitions.add(competition.copy(isFavourite = true))
        }
    }

    /**
     * @author Abdurrahman & Najeia
     * */
    suspend fun saveCompetitions(): Boolean {
        footballRepository.addLeagueList(selectedCompetitions)
        return true
    }

    /**
     * @author Abdurrahman & Mujtaba & Shehab
     * */
    suspend fun favoriteCompetition(competitionId: Int, season: String): League {
        getCompetitionByIdAndSeason(competitionId, season).let {
            footballRepository.updateOrInsertLeague(
                League(
                    competitionId = it.competitionId,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    season = it.season,
                    seasonStartYear = it.seasonStartYear,
                    seasonEndYear = it.seasonEndYear,
                    isFavourite = !it.isFavourite,
                    countryName = it.countryName,
                    leagueTypeName = it.leagueTypeName,
                    leagueCount = 1
                )
            )
        }
        return getCompetitionByIdAndSeason(competitionId, season)
    }

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String {
        return footballRepository.getCurrentRoundByIdAndSeason(leagueId, season)
            ?: "Finished"
    }
}