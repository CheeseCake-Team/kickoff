package com.cheesecake.domain.usecases.trophies

import com.cheesecake.data.repository.trophies.TrophiesRepository
import javax.inject.Inject

class GetPlayerTrophiesUseCases
@Inject constructor(private val TrophiesRepository: TrophiesRepository) {

//    suspend operator fun invoke(playerId: Int): Trophy {
//        val dtoResponse = getPlayerTrophiesResponse(playerId)
//        return mapResponseIntoShort(dtoResponse!!)
//    }
//
//    private suspend fun getPlayerTrophiesResponse(playerId: Int): TrophyDTO? {
//        return TrophiesRepository.getPlayerTrophies(playerId).body()?.response?.get(0)
//    }
//
//    private fun mapResponseIntoShort(input: TrophyDTO): Trophy {
//        return TrophiesDtoDomain().map(input)
//    }
}