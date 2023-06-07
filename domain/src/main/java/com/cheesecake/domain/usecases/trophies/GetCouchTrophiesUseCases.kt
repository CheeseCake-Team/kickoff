package com.cheesecake.domain.usecases.trophies

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetCouchTrophiesUseCases
@Inject constructor(private val iFootballRepository: IFootballRepository) {

//    suspend operator fun invoke(coachId: Int): Trophy {
//        val dtoResponse = getCoachTrophiesResponse(coachId)
//        return mapResponseIntoShort(dtoResponse!!)
//    }
//
//    private suspend fun getCoachTrophiesResponse(coachId: Int): TrophyDTO? {
//        return TrophiesRepository.getCoachTrophies(coachId).body()?.response?.get(0)
//    }
//
//    private fun mapResponseIntoShort(input: TrophyDTO): Trophy {
//        return TrophiesDtoDomain().map(input)
//    }
}