package com.cheesecake.domain.usecases

import com.cheesecake.data.models.StandingsResponse
import com.cheesecake.data.remote.standings.StandingsRepository
import com.cheesecake.domain.mappers.StandingsDtoToShortStandingsDomain
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
        return StandingsDtoToShortStandingsDomain().map(input)
    }

}