package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.remote.models.LeagueDTO
import com.cheesecake.domain.entity.League


fun LeagueDTO.toEntity(): League = League(
    leagueId = this.league.id,
    name = this.league.name,
    season = this.seasons.first().year.toString(),
    imageUrl = this.league.logo,
    seasonStartYear = this.seasons.first().start.substring(0, 4),
    seasonEndYear = this.seasons.first().end.substring(0, 4),
    country = this.country.name,
    isFavourite = false,
    typeName = this.league.type
)

@JvmName("leagueDTOToLeagueLocalDTO")
fun LeagueDTO.toLocal(): LeagueLocalDTO = LeagueLocalDTO(
    leagueId = this.league.id,
    leagueName = this.league.name,
    leagueSeason = this.seasons.first().year.toString(),
    leagueLogoUrl = this.league.logo,
    seasonStartYear = this.seasons.first().start,
    seasonEndYear = this.seasons.first().end,
    country = this.country.name,
    isFavourite = false,
    typeName = league.type
)

@JvmName("leagueLocalDTOToLeague")
fun LeagueLocalDTO.toEntity(): League = League(
    leagueId = leagueId,
    name = leagueName,
    season = leagueSeason,
    imageUrl = leagueLogoUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    country = country,
    isFavourite = isFavourite,
    typeName = typeName
)

@JvmName("leagueToLeagueLocalDTO")
fun League.toLocal(): LeagueLocalDTO = LeagueLocalDTO(
    leagueId = leagueId,
    leagueName = name,
    leagueSeason = season,
    leagueLogoUrl = imageUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    country = country,
    isFavourite = isFavourite,
    typeName = typeName
)

@JvmName("leagueLocalDTOsToLeagues")
fun List<LeagueLocalDTO>.toEntity(): List<League> = map { it.toEntity() }

@JvmName("leagueDTOsToLeagueLocalDTOs")
fun List<LeagueDTO>.toLocal(): List<LeagueLocalDTO> = map { it.toLocal() }

@JvmName("leagueDTOsToLeagues")
fun List<LeagueDTO>.toEntity(): List<League> = map { it.toEntity() }


