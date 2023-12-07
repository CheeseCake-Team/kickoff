package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.cheesecake.domain.entity.Team

@JvmName("teamDTOToTeam")
fun TeamDTO.toEntity(): Team = Team(
    id = this.team.id,
    name = this.team.name,
    yearFounded = this.team.founded ?: 0,
    country = this.team.country ?: "Unknown Country",
    stadiumCapacity = this.venue.capacity ?: 0,
    stadiumName = this.venue.name ?: "Unknown Stadium",
    imageUrl = this.team.logo,
    isFavourite = false
)

@JvmName("teamToTeamLocalDTO")
fun Team.toLocal(leagueId: Int, season: Int): TeamLocalDTO = TeamLocalDTO(
    teamId = id,
    leagueId = leagueId,
    season = season,
    teamName = this.name,
    founded = this.yearFounded,
    teamCountry = this.country,
    venueCapacity = this.stadiumCapacity,
    venueName = this.stadiumName,
    imageUrl = this.imageUrl,
    isFavourite = this.isFavourite
)

@JvmName("teamLocalDTOToTeam")
fun TeamLocalDTO.toEntity(): Team = Team(
    teamId, teamName, founded, teamCountry, venueCapacity, venueName, imageUrl, isFavourite
)

@JvmName("teamLocalDTOsToTeams")
fun List<TeamLocalDTO>.toEntity(): List<Team> = map { it.toEntity() }

@JvmName("teamsToTeamsLocalDTO")
fun List<Team>.toLocal(leagueId: Int, season: Int): List<TeamLocalDTO> =
    map { it.toLocal(leagueId, season) }

@JvmName("teamDTOsToTeams")
fun List<TeamDTO>.toEntity(): List<Team> =
    map { it.toEntity() }
