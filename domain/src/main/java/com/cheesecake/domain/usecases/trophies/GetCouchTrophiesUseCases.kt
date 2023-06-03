package com.cheesecake.domain.usecases.trophies

import com.cheesecake.data.models.dto.TrophyDTO
import com.cheesecake.data.remote.trophies.TrophiesRepository
import com.cheesecake.domain.mappers.trophies.TrophiesDtoDomain
import com.cheesecake.domain.models.trophies.SingleTrophy
import javax.inject.Inject

class GetCouchTrophiesUseCases
@Inject constructor(private val TrophiesRepository: TrophiesRepository) {

    suspend operator fun invoke(coachId: Int): SingleTrophy {
        val dtoResponse = getCoachTrophiesResponse(coachId)
        return mapResponseIntoShort(dtoResponse!!)
    }

    private suspend fun getCoachTrophiesResponse(coachId: Int): TrophyDTO? {
        return TrophiesRepository.getCoachTrophies(coachId).body()?.response?.get(0)
    }

    private fun mapResponseIntoShort(input: TrophyDTO): SingleTrophy {
        return TrophiesDtoDomain().map(input)
    }
}