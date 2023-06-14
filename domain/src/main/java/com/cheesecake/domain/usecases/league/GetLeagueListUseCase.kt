package com.cheesecake.domain.usecases.league

import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetLeagueListUseCase @Inject constructor(
    private val leagueRepository: IFootballRepository
) {

    suspend operator fun invoke(): List<LeagueEntity>{
        val leagues = leagueRepository.getAllLeagues()
        return leagues.shuffled()
    }
}