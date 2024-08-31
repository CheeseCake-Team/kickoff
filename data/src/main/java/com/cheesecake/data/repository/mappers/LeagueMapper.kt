package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.remote.models.LeagueDTO
import com.cheesecake.domain.entity.League


fun LeagueDTO.toEntity(): League = League(
    competitionId = this.league.id,
    name = this.league.name,
    season = this.seasons.map { it.year },
    imageUrl = this.league.logo,
    seasonStartYear = this.seasons.last().start.substring(0, 4),
    seasonEndYear = this.seasons.last().end.substring(0, 4),
    countryName = this.country.name,
    isFavourite = false,
    leagueTypeName = this.league.type,
    leagueCount = 1
)

@JvmName("leagueDTOToLeagueLocalDTO")
fun LeagueDTO.toLocal(): LeagueLocalDTO = LeagueLocalDTO(
    leagueId = this.league.id,
    leagueName = this.league.name,
    leagueSeason = this.seasons.map { it.year }.last(),
    leagueLogoUrl = this.league.logo,
    seasonStartYear = this.seasons.last().start,
    seasonEndYear = this.seasons.last().end,
    country = this.country.name,
    isFavourite = false,
    typeName = league.type
)

@JvmName("leagueLocalDTOToLeague")
fun LeagueLocalDTO.toEntity(): League = League(
    competitionId = leagueId,
    name = leagueName,
    season = listOf(leagueSeason) ,
    imageUrl = leagueLogoUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    countryName = country,
    isFavourite = isFavourite,
    leagueTypeName = typeName,
    leagueCount = 1
)

@JvmName("leagueToLeagueLocalDTO")
fun League.toLocal(): LeagueLocalDTO = LeagueLocalDTO(
    leagueId = competitionId,
    leagueName = name,
    leagueSeason = season.last(),
    leagueLogoUrl = imageUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    country = countryName,
    isFavourite = isFavourite,
    typeName = leagueTypeName
)

@JvmName("leagueLocalDTOsToLeagues")
fun List<LeagueLocalDTO>.toEntity(): List<League> = map { it.toEntity() }

@JvmName("leagueDTOsToLeagueLocalDTOs")
fun List<LeagueDTO>.toLocal(): List<LeagueLocalDTO> = map { it.toLocal() }

@JvmName("leagueDTOsToLeagues")
fun List<LeagueDTO>.toEntity(): List<League> = map { it.toEntity() }

