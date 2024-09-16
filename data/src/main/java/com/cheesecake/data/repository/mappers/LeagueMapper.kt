package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.CompetitionLocalDto
import com.cheesecake.data.remote.models.LeagueDTO
import com.cheesecake.domain.entity.Competition


fun LeagueDTO.toEntity(): Competition = Competition(
    competitionId = this.league.id,
    name = this.league.name,
    season = this.seasons.map { it.year },
    imageUrl = this.league.logo,
    seasonStartYear = this.seasons.last().start.substring(0, 4),
    seasonEndYear = this.seasons.last().end.substring(0, 4),
    countryName = this.country.name,
    leagueTypeName = this.league.type,
)

@JvmName("leagueDTOToLeagueLocalDTO")
fun LeagueDTO.toLocal(): CompetitionLocalDto = CompetitionLocalDto(
    id = this.league.id,
    name = this.league.name,
    season = this.seasons.map { it.year }.last(),
    imageUrl = this.league.logo,
    seasonStartYear = this.seasons.last().start,
    seasonEndYear = this.seasons.last().end,
    country = this.country.name,
    typeName = league.type
)

@JvmName("leagueLocalDTOToLeague")
fun CompetitionLocalDto.toEntity(): Competition = Competition(
    competitionId = id,
    name = name,
    season = listOf(season) ,
    imageUrl = imageUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    countryName = country,
    leagueTypeName = typeName
)

@JvmName("leagueToLeagueLocalDTO")
fun Competition.toLocal(): CompetitionLocalDto = CompetitionLocalDto(
    id = competitionId,
    name = name,
    season = season.last(),
    imageUrl = imageUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    country = countryName,
    typeName = leagueTypeName
)

@JvmName("leagueLocalDTOsToLeagues")
fun List<CompetitionLocalDto>.toEntity(): List<Competition> = map { it.toEntity() }

@JvmName("leagueDTOsToLeagueLocalDTOs")
fun List<LeagueDTO>.toLocal(): List<CompetitionLocalDto> = map { it.toLocal() }

@JvmName("leagueDTOsToLeagues")
fun List<LeagueDTO>.toEntity(): List<Competition> = map { it.toEntity() }

