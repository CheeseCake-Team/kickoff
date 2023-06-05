package com.cheesecake.domain.usecases.fixture

import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.repository.fixture.FixturesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleFixtureByIdUseCase @Inject constructor(
    private val fixturesRepository: FixturesRepository,
) {
    suspend operator fun invoke(timeZone: String, fixtureId: Int): List<FixtureResponse> {
        return fixturesRepository.getFixtureById(timeZone, fixtureId)
    }
}

