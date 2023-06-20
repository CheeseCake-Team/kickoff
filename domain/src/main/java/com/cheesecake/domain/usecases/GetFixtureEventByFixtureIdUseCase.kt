package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetFixtureEventByFixtureIdUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
){
    suspend operator fun invoke(fixtureId : Int) = footballRepository.getFixtureEventByFixtureId(fixtureId).reversed()
}