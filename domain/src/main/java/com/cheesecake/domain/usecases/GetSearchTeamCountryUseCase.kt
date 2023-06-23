package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchTeamCountryUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(search: String): Flow<List<Country>> =
        footballRepository.getCountriesSearch(search)

}