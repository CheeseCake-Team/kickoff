package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamBySearchUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    suspend operator fun invoke(teamName: String): List<Team> {
        return repository.getTeamsBySearch(teamName)
    }

}