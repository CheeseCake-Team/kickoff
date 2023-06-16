package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.StandingsDTO
import com.cheesecake.domain.entity.TeamStanding

@JvmName("teamStandingDTOToTeamStanding")
fun StandingsDTO.League.Standing.toEntity(): TeamStanding {
    return TeamStanding(
        teamId = this.team.id,
        form = this.form,
        logo = this.team.logo,
        name = this.team.name,
        played = this.all.played.toString(),
        won = this.all.win.toString(),
        draw = this.all.draw.toString(),
        lose = this.all.lose.toString(),
        points = this.points.toString(),
        goals = "${this.all.goals.forX}:${this.all.goals.against}"
    )
}

@JvmName("teamStandingsDTOsToTeamsStanding")
fun List<StandingsDTO>.toEntity(): List<TeamStanding> {
    return this.first().league.standings.first().map { standingsResponse ->
        standingsResponse.toEntity()
    }
}