package com.cheesecake.data.mappers

import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.domain.models.Team

fun TeamLocalDto.toEntity(): Team {
    return Team(
        teamId = this.teamId,
        teamName = this.teamName,
        founded = this.founded,
        teamCountry = this.teamCountry,
        venueCapacity = this.venueCapacity,
        venueName = this.venueName,
        imageUrl = this.imageUrl
    )
}