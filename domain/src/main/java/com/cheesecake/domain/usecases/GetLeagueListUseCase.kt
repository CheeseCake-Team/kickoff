package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetLeagueListUseCase @Inject constructor(
    private val leagueRepository: IFootballRepository
) {

    suspend operator fun invoke(): List<League>{
        val leagues = leagueRepository.getAllLeagues()
        return leagues.shuffled()
    }
}