package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.cheesecake.domain.entity.Team

@JvmName("teamDTOToTeam")
fun TeamDTO.toEntity(): Team = Team(
    teamId = this.team.id,
    teamName = this.team.name,
    founded = this.team.founded,
    teamCountry = this.team.country,
    venueCapacity = this.venue.capacity,
    venueName = this.venue.name,
    imageUrl = this.team.logo,
    isFavourite = false
)

@JvmName("teamToTeamLocalDTO")
fun Team.toLocal(leagueId: Int, leagueSeason: Int): TeamLocalDTO = TeamLocalDTO(
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

@JvmName("teamLocalDTOToTeam")
fun TeamLocalDTO.toEntity(): Team = Team(
    teamId, teamName, founded, teamCountry, venueCapacity, venueName, imageUrl, isFavourite
)

@JvmName("teamLocalDTOsToTeams")
fun List<TeamLocalDTO>.toEntity(): List<Team> = map { it.toEntity() }

@JvmName("teamsToTeamsLocalDTO")
fun List<Team>.toLocal(leagueId: Int, leagueSeason: Int): List<TeamLocalDTO> =
    map { it.toLocal(leagueId, leagueSeason) }

@JvmName("teamDTOsToTeams")
fun List<TeamDTO>.toEntity(): List<Team> =
    map { it.toEntity() }
