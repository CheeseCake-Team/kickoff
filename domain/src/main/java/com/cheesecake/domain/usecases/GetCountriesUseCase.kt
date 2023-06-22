package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(): List<Country> =
        footballRepository.getLocalCountries().takeIf { it.isNotEmpty() }
            ?: footballRepository.getRemoteCountries().also {
                footballRepository.updateOrInsertCountries(it)
            }

}