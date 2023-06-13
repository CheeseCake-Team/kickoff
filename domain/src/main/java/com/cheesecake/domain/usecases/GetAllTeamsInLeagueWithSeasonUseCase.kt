package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetAllTeamsInLeagueWithSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(leagueId: Int, leagueSeason: Int): List<Team> =
        footballRepository.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
            .takeIf { it.isNotEmpty() }
            ?: footballRepository.getRemotelyTeamsByIdAndSeason(leagueId, leagueSeason).also {
                footballRepository.updateOrInsertTeams(it, leagueId, leagueSeason)
            }

}