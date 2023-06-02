package com.cheesecake.domain.usecases.standings

import com.cheesecake.data.models.StandingsResponse
import com.cheesecake.domain.mappers.standings.StandingsDtoDomain
import com.cheesecake.domain.models.ShortStandings
import javax.inject.Inject

class GetShortStandingsDataUseCases
@Inject constructor(private val standingsRepository: StandingsRepository) {

    suspend operator fun invoke(seasonId: Int, leagueId: Int): ShortStandings {
        val dtoResponse = getSingleStandingResponse(seasonId, leagueId)
        return mapResponseIntoShort(dtoResponse!!)
    }

    private suspend fun getSingleStandingResponse(seasonId: Int, leagueId: Int): StandingsResponse? {
        return standingsRepository.getStandingsByLeagueId(seasonId, leagueId).body()?.response?.get(0)
    }

    private fun mapResponseIntoShort(input: StandingsResponse): ShortStandings {
        return StandingsDtoDomain().map(input)
    }

}