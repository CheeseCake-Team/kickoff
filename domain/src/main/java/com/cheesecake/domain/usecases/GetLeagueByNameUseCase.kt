package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetLeagueByNameUseCase @Inject constructor(
    private val repository: IFootballRepository,
) {

    suspend operator fun invoke(leagueName: String): List<LeagueEntity> {
        return repository.getLeaguesByName(leagueName)
    }

}