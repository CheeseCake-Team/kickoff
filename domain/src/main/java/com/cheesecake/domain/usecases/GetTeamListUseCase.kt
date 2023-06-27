package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetTeamListUseCase @Inject constructor(
    private val Repository: IFootballRepository
) {

    suspend operator fun invoke(leagues: List<League>): List<Team> {
        return leagues.flatMap { league ->
            Repository.getRemotelyTeamsByIdAndSeason(league.leagueId, league.season.last())
        }
    }

}