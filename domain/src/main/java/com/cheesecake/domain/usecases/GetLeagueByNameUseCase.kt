package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLeagueByNameUseCase @Inject constructor(
    private val repository: IFootballRepository,
) {

    suspend operator fun invoke(leagueName: String): Flow<List<LeagueEntity>> {
        return flow {
            emit(repository.getLeaguesByName(leagueName))
        }
    }

}