package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamCountryUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(): List<TeamCountry> =
        footballRepository.getLocalCountries().takeIf { it.isNotEmpty() }
            ?: footballRepository.getRemoteCountries().also {
                footballRepository.addTeamCountries(it)
            }

}