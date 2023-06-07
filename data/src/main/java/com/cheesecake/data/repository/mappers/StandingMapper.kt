package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.response.StandingsResponse
import com.cheesecake.domain.entity.TeamStandingEntity


fun StandingsResponse.mapRemoteDtoToEntity(index: Int): TeamStandingEntity {
    return TeamStandingEntity(
        teamId = this.league.standings[0][index].team.id,
        season = this.league.season,
        form = this.league.standings[0][index].form,
        logo = this.league.standings[0][index].team.logo,
        name = this.league.standings[0][index].team.name,
        played = this.league.standings[0][index].all.played,
        won = this.league.standings[0][index].all.win,
        draw = this.league.standings[0][index].all.draw,
        lose = this.league.standings[0][index].all.lose,
        points = this.league.standings[0][index].points,
    )
}

fun List<StandingsResponse>.mapRemoteDtoToEntity():List<TeamStandingEntity>{
    return this.mapIndexed { index, standingsResponse ->
        standingsResponse.mapRemoteDtoToEntity(index)
    }
}