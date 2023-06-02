package com.cheesecake.domain.usecases.trophies

import com.cheesecake.data.models.SingleTrophyResponse
import com.cheesecake.domain.mappers.trophies.TrophiesDtoDomain
import com.cheesecake.domain.models.SingleTrophy
import javax.inject.Inject

class GetPlayerTrophiesUseCases
@Inject constructor(private val TrophiesRepository: TrophiesRepository) {

    suspend operator fun invoke(playerId: Int): SingleTrophy {
        val dtoResponse = getPlayerTrophiesResponse(playerId)
        return mapResponseIntoShort(dtoResponse!!)
    }

    private suspend fun getPlayerTrophiesResponse(playerId: Int): SingleTrophyResponse? {
        return TrophiesRepository.getPlayerTrophies(playerId).body()?.response?.get(0)
    }

    private fun mapResponseIntoShort(input: SingleTrophyResponse): SingleTrophy {
        return TrophiesDtoDomain().map(input)
    }
}