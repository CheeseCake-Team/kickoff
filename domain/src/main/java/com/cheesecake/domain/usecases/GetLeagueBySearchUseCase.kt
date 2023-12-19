package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetLeagueBySearchUseCase @Inject constructor(
    private val repository: IFootballRepository,
) {
    suspend operator fun invoke(leagueName: String): List<League> {
        return repository.getLeaguesBySearch(leagueName)
    }
}