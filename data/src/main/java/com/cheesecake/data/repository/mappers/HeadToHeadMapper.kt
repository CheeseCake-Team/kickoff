package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.HeadToHeadDTO
import com.cheesecake.domain.entity.Match

@JvmName("HeadToHeadDTOToMatches")
fun HeadToHeadDTO.toEntity(): Match {
    return Match(
        fixtureId = this.fixtureDataDTO.id,
        homeTeamId = this.teams.home.id,
        homeTeamName = this.teams.home.name,
        homeTeamLogoUrl = this.teams.home.logo,
        homeTeamGoals = this.goals.home,
        awayTeamId = this.teams.away.id,
        awayTeamName = this.teams.away.name,
        awayTeamLogoUrl = this.teams.away.logo,
        awayTeamGoals = this.goals.away,
        matchState = this.fixtureDataDTO.status.long
    )
}

@JvmName("HeadToHeadDTOToMatches")
fun List<HeadToHeadDTO>.toEntity(): List<Match> {
    return this.map { it.toEntity() }
}