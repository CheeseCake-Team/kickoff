package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.domain.Entity.Team

fun TeamLocalDto.toEntity(): Team = Team(
    teamId = this.teamId,
    teamName = this.teamName,
    founded = this.founded,
    teamCountry = this.teamCountry,
    venueCapacity = this.venueCapacity,
    venueName = this.venueName,
    imageUrl = this.imageUrl
)


fun TeamLocalDto.toLocal(): TeamLocalDto = TeamLocalDto(
    teamId = this.teamId,
    teamName = this.teamName,
    founded = this.founded,
    teamCountry = this.teamCountry,
    venueCapacity = this.venueCapacity,
    venueName = this.venueName,
    imageUrl = this.imageUrl,
    isFavourite = this.isFavourite
)



fun List<TeamLocalDto>.toEntity(): List<Team> = map { it.toEntity() }


