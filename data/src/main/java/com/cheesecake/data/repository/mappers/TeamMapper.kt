package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamLocalDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.cheesecake.domain.entity.Team

@JvmName("teamDTOToTeam")
fun TeamDTO.toEntity(): Team = Team(
    id = this.team.id,
    name = this.team.name,
    yearFounded = this.team.founded,
    country = this.team.country,
    stadiumCapacity = this.venue.capacity,
    stadiumName = this.venue.name,
    imageUrl = this.team.logo,
    isFavourite = false
)

@JvmName("teamToTeamLocalDTO")
fun Team.toLocal(leagueId: Int, leagueSeason: Int): TeamLocalDTO = TeamLocalDTO(
    teamId = id,
    leagueId = leagueId,
    season = leagueSeason,
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
fun List<Team>.toLocal(leagueId: Int, leagueSeason: Int): List<TeamLocalDTO> =
    map { it.toLocal(leagueId, leagueSeason) }

@JvmName("teamDTOsToTeams")
fun List<TeamDTO>.toEntity(): List<Team> =
    map { it.toEntity() }
