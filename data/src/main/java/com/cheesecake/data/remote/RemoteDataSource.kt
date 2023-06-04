package com.cheesecake.data.remote

import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.remote.response.FixtureResponse

interface RemoteDataSource {

    suspend fun getFixtureById(
        timeZone: String,
        fixtureId: Int
    ): List<FixtureResponse>

}