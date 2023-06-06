package com.cheesecake.domain.usecases.standings

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetShortStandingsDataUseCases
@Inject constructor(private val iFootballRepository: IFootballRepository) {

//    suspend operator fun invoke(seasonId: Int, leagueId: Int): ShortStandings {
//        val dtoResponse = getSingleStandingResponse(seasonId, leagueId)
//        return mapResponseIntoShort(dtoResponse!!)
//    }
//
//    private suspend fun getSingleStandingResponse(seasonId: Int, leagueId: Int): StandingsDTO? {
//        return standingsRepository.
//        getStandingsByLeagueId(seasonId, leagueId).body()?.response?.get(0)
//    }
//
//    private fun mapResponseIntoShort(input: StandingsDTO): ShortStandings {
//        return StandingsDtoDomain().map(input)
//    }

}