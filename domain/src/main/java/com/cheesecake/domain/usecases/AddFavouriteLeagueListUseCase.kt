package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class AddFavouriteLeagueListUseCase @Inject constructor(
    private val leagueRepository: IFootballRepository
) {

    private val selectedLeagues: MutableList<League> = mutableListOf()

    fun addLeague(league: League) {
        selectedLeagues.find { it == league }?.let {
            selectedLeagues.remove(league.copy(isFavourite = false))
        } ?: run {
            selectedLeagues.add(league.copy(isFavourite = true))
        }
    }

    suspend fun execute(): Boolean {
        leagueRepository.addLeagueList(selectedLeagues)
        return true
    }

}