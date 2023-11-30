package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val repository: IFootballRepository
) {
    suspend operator fun invoke(leagues: List<League>): List<Team> {
        return leagues.flatMap { league ->
            repository.getRemotelyTeamsByIdAndSeason(league.leagueId, league.season.last())
        }
    }
}