package com.cheesecake.domain.mappers.trophies

import com.cheesecake.data.models.SingleTrophyResponse
import com.cheesecake.domain.mappers.IMapper
import com.cheesecake.domain.models.trophies.SingleTrophy

class TrophiesDtoDomain : IMapper<SingleTrophyResponse, SingleTrophy> {

    override fun map(input: SingleTrophyResponse): SingleTrophy {
        return SingleTrophy(
            league = input.league,
            country = input.country,
            place = input.place,
            season = input.season
        )
    }
}