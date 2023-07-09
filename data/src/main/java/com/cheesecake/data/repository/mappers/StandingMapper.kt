package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.StandingsDTO
import com.cheesecake.domain.entity.TeamStanding

@JvmName("teamStandingDTOToTeamStanding")
fun StandingsDTO.League.Standing.toEntity(): TeamStanding {
    return TeamStanding(
        teamId = this.team.id,
        rank = this.rank,
        form = this.form.map { it.toString() },
        logo = this.team.logo,
        name = this.team.name,
        played = this.all.played,
        won = this.all.win,
        draw = this.all.draw,
        lose = this.all.lose,
        points = this.points,
        goalsForAgainst = "${this.all.goals.forX}:${this.all.goals.against}"
    )
}

@JvmName("teamStandingsDTOsToTeamsStanding")
fun List<StandingsDTO>.toEntity(): List<TeamStanding> {
    return this.first().league.standings.first().map { standingsResponse ->
        standingsResponse.toEntity()
    }
}