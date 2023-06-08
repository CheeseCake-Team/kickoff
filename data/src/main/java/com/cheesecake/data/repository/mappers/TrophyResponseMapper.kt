package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.response.TrophyResponse
import com.cheesecake.domain.entity.TrophyEntity

fun TrophyResponse.mapToDomain(): TrophyEntity {
    return TrophyEntity(
        league,
        country,
        place,
        season
    )
}

fun List<TrophyResponse>.mapToDomain():List<TrophyEntity>{
    return this.map { it.mapToDomain() }
}