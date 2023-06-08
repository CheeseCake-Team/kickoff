package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.response.StandingsResponse
import com.cheesecake.domain.entity.TeamStandingEntity

fun StandingsResponse.League.Standing.mapRemoteDtoToEntity(): TeamStandingEntity {
    return TeamStandingEntity(
        teamId = this.team.id,
        form = this.form,
        logo = this.team.logo,
        name = this.team.name,
        played = this.all.played.toString(),
        won = this.all.win.toString(),
        draw = this.all.draw.toString(),
        lose = this.all.lose.toString(),
        points = this.points.toString()
    )
}

fun List<StandingsResponse>.mapRemoteDtoToEntity():List<TeamStandingEntity>{
    return this.first().league.standings.first().map { standingsResponse ->
        standingsResponse.mapRemoteDtoToEntity()
    }
}