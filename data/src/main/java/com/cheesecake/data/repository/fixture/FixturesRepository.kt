package com.cheesecake.data.repository.fixture

import com.cheesecake.data.remote.response.FixtureResponse

interface FixturesRepository {
    suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<FixtureResponse>
}