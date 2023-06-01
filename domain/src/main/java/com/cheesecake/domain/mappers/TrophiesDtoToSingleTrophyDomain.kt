package com.cheesecake.domain.mappers

import com.cheesecake.data.models.SingleTrophyResponse
import com.cheesecake.domain.models.SingleTrophy

class TrophiesDtoToSingleTrophyDomain : IMapper<SingleTrophyResponse, SingleTrophy> {

    override fun map(input: SingleTrophyResponse): SingleTrophy {
        return SingleTrophy(
            league = input.league,
            country = input.country,
            place = input.place,
            season = input.season
        )
    }
}