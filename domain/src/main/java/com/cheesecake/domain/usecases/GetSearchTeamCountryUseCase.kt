package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetSearchTeamCountryUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(search: String): Flow<List<TeamCountry>> =
        footballRepository.getCountriesSearch(search)

}