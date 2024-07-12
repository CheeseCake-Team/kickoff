package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ManageCountriesUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {
    /**
     * @author Ziad & Abdurrahman
     * */
    suspend fun getCountries(): List<Country> =
        footballRepository.getLocalCountries().takeIf { it.isNotEmpty() }
            ?: footballRepository.getRemoteCountries().also {
                footballRepository.updateOrInsertCountries(it)
            }

    /**
     * @author Ziad
     * */
    suspend fun searchForCountries(countryName: String): Flow<List<Country>> =
        footballRepository.getCountriesSearch(countryName)
}