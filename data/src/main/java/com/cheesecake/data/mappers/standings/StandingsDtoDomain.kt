package com.cheesecake.data.mappers.standings

import com.cheesecake.data.models.dto.StandingsDTO
import com.cheesecake.data.mappers.IMapper
import com.cheesecake.domain.models.ShortStandings

class StandingsDtoDomain : IMapper<StandingsDTO, ShortStandings> {
    override fun map(input: StandingsDTO): ShortStandings {
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