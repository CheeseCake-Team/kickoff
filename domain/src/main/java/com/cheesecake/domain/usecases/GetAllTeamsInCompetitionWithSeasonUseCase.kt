package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetAllTeamsInCompetitionWithSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {
    suspend operator fun invoke(leagueId: Int, leagueSeason: Int): List<Team> =
        footballRepository.getRemotelyTeamsByIdAndSeason(leagueId, leagueSeason)
    /*footballRepository.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
                .takeIf { it.isNotEmpty() }
                ?: .also {
                    footballRepository.updateOrInsertTeams(it, leagueId, leagueSeason)
                }*/
}