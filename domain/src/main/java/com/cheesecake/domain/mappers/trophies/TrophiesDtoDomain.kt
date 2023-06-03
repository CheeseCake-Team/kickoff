package com.cheesecake.domain.mappers.trophies

import com.cheesecake.data.models.TrophyDTO
import com.cheesecake.domain.mappers.IMapper
import com.cheesecake.domain.models.trophies.SingleTrophy

class TrophiesDtoDomain : IMapper<TrophyDTO, SingleTrophy> {

    override fun map(input: TrophyDTO): SingleTrophy {
        return SingleTrophy(
            league = input.league,
            country = input.country,
            place = input.place,
            season = input.season
        )
    }
}