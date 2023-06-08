package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTeamByNameUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    suspend operator fun invoke(teamName: String): Flow<List<TeamEntity>> {
        return flow {
            emit(repository.getTeamsByName(teamName))
        }
    }

}