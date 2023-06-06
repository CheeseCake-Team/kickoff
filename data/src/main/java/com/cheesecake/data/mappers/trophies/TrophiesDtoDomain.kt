package com.cheesecake.data.mappers.trophies

import com.cheesecake.data.models.dto.TrophyDTO
import com.cheesecake.data.mappers.IMapper
import com.cheesecake.domain.models.Trophy

class TrophiesDtoDomain : IMapper<TrophyDTO, Trophy> {

    override fun map(input: TrophyDTO): Trophy {
        return Trophy(
            league = input.league,
            country = input.country,
            place = input.place,
            season = input.season
        )
    }
}