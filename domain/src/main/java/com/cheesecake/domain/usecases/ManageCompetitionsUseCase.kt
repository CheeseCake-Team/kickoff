package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ManageCompetitionsUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {
    /**
     * @author Najeia
     * */
    suspend fun getCompetitions(): List<Competition> {
        val competitions = footballRepository.getCompetitions()
        return competitions.shuffled()
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getCompetitionsByCountryName(countryName: String): List<Competition> =
        footballRepository.getCompetitionsByCountryName(countryName)

    /**
     * @author Shehab
     * */
    suspend fun getCompetitionByIdAndSeason(competitionId: Int, season: String): Competition {
        return footballRepository.getRemotelyLeagueByIdAndSeason(competitionId, season)
    }

    /**
     * @author Shehab
     * */
    suspend fun searchForCompetitions(competitionName: String): List<Competition> {
        return footballRepository.searchForCompetitions(competitionName)
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getFavoriteCompetition(): Flow<List<Competition>> =
        footballRepository.getFavoriteCompetition()

    /**
     * @author Abdurrahman
     * */
    suspend fun isCompetitionFavorite(competitionId: Int): Flow<Boolean> {
        return footballRepository.getFavoriteCompetition()
            .map { favoriteCompetitions ->
                favoriteCompetitions.any { it.competitionId == competitionId }
            }
    }

    private val selectedCompetitions: MutableList<Competition> = mutableListOf()

    /**
     * @author Abdurrahman & Najeia
     * */
    fun addCompetition(competition: Competition) {
        selectedCompetitions.find { it.competitionId == competition.competitionId }?.let {
            selectedCompetitions.removeIf { it.competitionId == competition.competitionId }
        } ?: run {
            selectedCompetitions.add(competition)
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
    suspend fun favoriteCompetition(competitionId: Int, season: String) {
        getCompetitionByIdAndSeason(competitionId, season).let {
            footballRepository.updateOrInsertLeague(it)
        }
    }

    suspend fun getCurrentRoundByIdAndSeason(leagueId: Int, season: Int): String {
        return footballRepository.getCurrentRoundByIdAndSeason(leagueId, season)
            ?: "Finished"
    }

    suspend fun removeFavoriteCompetition(competitionId: Int) {
        return footballRepository.deleteLeagueById(competitionId)
    }
}