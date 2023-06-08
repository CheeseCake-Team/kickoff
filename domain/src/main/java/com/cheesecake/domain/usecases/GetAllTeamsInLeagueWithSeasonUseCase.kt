package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetAllTeamsInLeagueWithSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(leagueId: Int, leagueSeason: Int): List<TeamEntity> {
        val localTeams = footballRepository.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
        if (localTeams.isEmpty()) {
            val remoteTeams = footballRepository.getRemotelyTeamsByIdAndSeason(leagueId, leagueSeason)
            footballRepository.updateOrInsertTeams(remoteTeams, leagueId, leagueSeason)
        }
        return footballRepository.getLocallyTeamsByIdAndSeason(leagueId, leagueSeason)
    }

}