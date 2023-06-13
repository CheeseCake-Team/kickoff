package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.remote.models.LeagueDTO
import com.cheesecake.domain.entity.League


fun LeagueDTO.toEntity(): League = League(
    leagueId = this.league.id,
    leagueName = this.league.name,
    leagueSeason = this.seasons.first().year.toString(),
    leagueLogo = this.league.logo,
    seasonStartYear = this.seasons.first().start.substring(0, 4),
    seasonEndYear = this.seasons.first().end.substring(0, 4),
    country = this.country.name,
    isFavourite = false
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
    isFavourite = false
)

@JvmName("leagueLocalDTOToLeague")
fun LeagueLocalDTO.toEntity(): League = League(
    leagueId = leagueId,
    leagueName = leagueName,
    leagueSeason = leagueSeason,
    leagueLogo = leagueLogoUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    country = country,
    isFavourite = isFavourite
)

@JvmName("leagueToLeagueLocalDTO")
fun League.toLocal(): LeagueLocalDTO = LeagueLocalDTO(
    leagueId = leagueId,
    leagueName = leagueName,
    leagueSeason = leagueSeason,
    leagueLogoUrl = leagueLogo,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    country = country,
    isFavourite = isFavourite
)

@JvmName("leagueLocalDTOsToLeagues")
fun List<LeagueLocalDTO>.toEntity(): List<League> = map { it.toEntity() }

@JvmName("leagueDTOsToLeagueLocalDTOs")
fun List<LeagueDTO>.toLocal(): List<LeagueLocalDTO> = map { it.toLocal() }

@JvmName("leagueDTOsToLeagues")
fun List<LeagueDTO>.toEntity(): List<League> = map { it.toEntity() }


