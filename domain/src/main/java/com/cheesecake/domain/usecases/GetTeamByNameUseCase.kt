package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamByNameUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    suspend operator fun invoke(teamName:String): List<TeamEntity> {
        return repository.getTeamsByName(teamName)
    }

}