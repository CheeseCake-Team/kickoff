package com.cheesecake.domain.usecases

import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.data.repository.TeamsRepository
import com.cheesecake.domain.models.TeamEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllTeamsInLeagueWithSeason @Inject constructor(
    private val teamsRepository: TeamsRepository,
) {

    suspend operator fun invoke(leagueId: Int, season: Int) : Flow<List<TeamEntity>> {
        return teamsRepository.getTeamsByLeagueAndSeason(leagueId, season).map { localTeamsDto ->
            localTeamsDto.map { it.toEntity() }
        }
    }


}