package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetCountryTeamsUseCase @Inject constructor(private val repository: IFootballRepository) {

    suspend operator fun invoke(countryName: String): List<Team> = repository.getTeamsByCountryName(countryName)


}