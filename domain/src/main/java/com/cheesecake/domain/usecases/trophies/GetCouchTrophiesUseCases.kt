package com.cheesecake.domain.usecases.trophies

import com.cheesecake.data.models.SingleTrophyResponse
import com.cheesecake.data.remote.trophies.TrophiesRepository
import com.cheesecake.domain.mappers.TrophiesDtoToSingleTrophyDomain
import com.cheesecake.domain.models.SingleTrophy
import javax.inject.Inject

class GetCouchTrophiesUseCases
@Inject constructor(private val TrophiesRepository: TrophiesRepository) {

    suspend operator fun invoke(coachId: Int): SingleTrophy {
        val dtoResponse = getCoachTrophiesResponse(coachId)
        return mapResponseIntoShort(dtoResponse!!)
    }

    private suspend fun getCoachTrophiesResponse(coachId: Int): SingleTrophyResponse? {
        return TrophiesRepository.getCoachTrophies(coachId).body()?.response?.get(0)
    }

    private fun mapResponseIntoShort(input: SingleTrophyResponse): SingleTrophy {
        return TrophiesDtoToSingleTrophyDomain().map(input)
    }
}