package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.TrophyDTO
import com.cheesecake.domain.entity.Trophy

@JvmName("trophyDTOToTrophy")
fun TrophyDTO.toEntity(): Trophy {
    return Trophy(
        league,
        country,
        place,
        season
    )
}

@JvmName("trophyDTOsToTrophies")
fun List<TrophyDTO>.toEntity():List<Trophy>{
    return this.map { it.toEntity() }
}