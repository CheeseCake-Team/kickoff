package com.cheesecake.data.models.mappers

import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.data.models.dto.TeamInformationDTO

fun TeamInformationDTO.toLocal() = TeamLocalDto(
    teamId = this.team.id,
    teamName = this.team.name,
    founded = this.team.founded,
    teamCountry = this.team.country,
    venueCapacity = this.venue.capacity,
    venueName = this.venue.name,
    imageUrl = this.team.logo
)