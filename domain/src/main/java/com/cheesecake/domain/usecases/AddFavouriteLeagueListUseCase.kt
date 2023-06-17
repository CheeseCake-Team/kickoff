package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class AddFavouriteLeagueListUseCase @Inject constructor(
    private val leagueRepository: IFootballRepository
) {

    suspend operator fun invoke(leagues: List<League>) : Boolean {
        leagueRepository.addLeagueList(leagues)
        return true
    }

}