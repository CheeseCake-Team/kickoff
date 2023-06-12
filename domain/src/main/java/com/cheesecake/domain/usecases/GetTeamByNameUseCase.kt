package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamByNameUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    suspend operator fun invoke(name: String): List<Team> {
        return repository.getTeamsBySearch(name)
    }

}