package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetLeaguesByCountryName @Inject constructor(private val repository: IFootballRepository) {

    suspend operator fun invoke(countryName: String) : List<League> = repository.getLeaguesByCountryName(countryName)

}