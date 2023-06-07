package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.remote.response.LeagueResponse
import com.cheesecake.domain.entity.LeagueEntity


fun LeagueResponse.mapRemoteDtoToEntity(): LeagueEntity = LeagueEntity(
    leagueId = this.league.id,
    leagueName = this.league.name,
    leagueSeason = this.seasons.first().year.toString(),
    leagueLogo = this.league.logo,
    seasonStartYear = this.seasons.first().start.substring(0, 4),
    seasonEndYear = this.seasons.first().end.substring(0, 4),
    isFavourite = false
)


fun LeagueResponse.mapToLocal(): LeagueLocalDto = LeagueLocalDto(
    leagueId = this.league.id,
    leagueName = this.league.name,
    leagueSeason = this.seasons.first().year.toString(),
    leagueLogoUrl = this.league.logo,
    seasonStartYear = this.seasons.first().start,
    seasonEndYear = this.seasons.first().end,
    isFavourite = false
)


fun LeagueLocalDto.mapRemoteDtoToEntity(): LeagueEntity = LeagueEntity(
    leagueId = leagueId,
    leagueName = leagueName,
    leagueSeason = leagueSeason,
    leagueLogo = leagueLogoUrl,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    isFavourite = isFavourite
)


fun LeagueEntity.toLocal(): LeagueLocalDto = LeagueLocalDto(
    leagueId = leagueId,
    leagueName = leagueName,
    leagueSeason = leagueSeason,
    leagueLogoUrl = leagueLogo,
    seasonStartYear = seasonStartYear,
    seasonEndYear = seasonEndYear,
    isFavourite = isFavourite
)


fun List<LeagueLocalDto>.mapLocalDtoToEntity(): List<LeagueEntity> = map { it.mapRemoteDtoToEntity() }


fun List<LeagueResponse>.mapToLocal(): List<LeagueLocalDto> = map { it.mapToLocal() }


fun List<LeagueResponse>.mapRemoteDtoToEntity(): List<LeagueEntity> = map { it.mapRemoteDtoToEntity() }


