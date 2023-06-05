package com.cheesecake.domain.usecases

import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.domain.models.TeamEntity

fun TeamLocalDto.toEntity(): TeamEntity {
    return TeamEntity(
        teamId = this.teamId,
        teamName = this.teamName,
        founded = this.founded,
        teamCountry = this.teamCountry,
        venueCapacity = this.venueCapacity,
        venueName = this.venueName,
        imageUrl = this.imageUrl
    )
}