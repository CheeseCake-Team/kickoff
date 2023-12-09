package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class AddCompetitionsToFavoriteUseCase @Inject constructor(
    private val leagueRepository: IFootballRepository
) {
    private val selectedLeagues: MutableList<League> = mutableListOf()

    fun addLeague(league: League) {
        selectedLeagues.find { it.leagueId == league.leagueId }?.let {
            selectedLeagues.removeIf { it.leagueId == league.leagueId }
        } ?: run {
            selectedLeagues.add(league.copy(isFavourite = true))
        }
    }

    suspend fun execute(): Boolean {
        leagueRepository.addLeagueList(selectedLeagues)
        return true
    }
}