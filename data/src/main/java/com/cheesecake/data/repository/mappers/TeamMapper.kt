package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.data.remote.response.TeamInformationResponse
import com.cheesecake.domain.entity.TeamEntity


fun TeamInformationResponse.mapRemoteDtoToEntity(): TeamEntity = TeamEntity(
    teamId = this.team.id,
    teamName = this.team.name,
    founded = this.team.founded,
    teamCountry = this.team.country,
    venueCapacity = this.venue.capacity,
    venueName = this.venue.name,
    imageUrl = this.team.logo,
    isFavourite = false
)


fun TeamEntity.toLocal(leagueId: Int, leagueSeason: Int): TeamLocalDto = TeamLocalDto(
    teamId = teamId,
    leagueId = leagueId,
    season = leagueSeason,
    teamName = this.teamName,
    founded = this.founded,
    teamCountry = this.teamCountry,
    venueCapacity = this.venueCapacity,
    venueName = this.venueName,
    imageUrl = this.imageUrl,
    isFavourite = this.isFavourite
)


fun TeamLocalDto.mapLocalDtoToEntity(): TeamEntity = TeamEntity(
    teamId, teamName, founded, teamCountry, venueCapacity, venueName, imageUrl, isFavourite
)


fun List<TeamLocalDto>.mapLocalDtoToEntity(): List<TeamEntity> = map { it.mapLocalDtoToEntity() }


fun List<TeamEntity>.mapToLocal(leagueId: Int, leagueSeason: Int): List<TeamLocalDto> =
    map { it.toLocal(leagueId, leagueSeason) }


fun List<TeamInformationResponse>.mapRemoteDtoToEntity(): List<TeamEntity> =
    map { it.mapRemoteDtoToEntity() }
