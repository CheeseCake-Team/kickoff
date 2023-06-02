package com.cheesecake.domain.mappers.standings

import com.cheesecake.data.models.StandingsResponse
import com.cheesecake.domain.mappers.IMapper
import com.cheesecake.domain.models.ShortStandings

class StandingsDtoDomain : IMapper<StandingsResponse, ShortStandings> {
    override fun map(input: StandingsResponse): ShortStandings {
        return ShortStandings(
            flag = input.league.flag,
            name = input.league.name,
            played = input.league.standings[0][0].all.played,
            won = input.league.standings[0][0].all.win,
            draw = input.league.standings[0][0].all.draw,
            lose = input.league.standings[0][0].all.lose,
            points = input.league.standings[0][0].points
        )
    }
}