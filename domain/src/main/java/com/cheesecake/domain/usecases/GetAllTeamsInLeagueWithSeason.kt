package com.cheesecake.domain.usecases

import com.cheesecake.data.repository.TeamsRepository
import com.cheesecake.domain.models.TeamEntity
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllTeamsInLeagueWithSeason @Inject constructor(
    private val teamsRepository: TeamsRepository,

    ) {

    suspend operator fun invoke(leagueId: Int, season: Int) =
         teamsRepository.getTeamsByLeagueAndSeason(leagueId, season).map { localTeams ->
             localTeams.map {
                 TeamEntity(
                     teamId = it.teamId,
                     teamName = it.teamName,
                     founded = it.founded,
                     teamCountry = it.teamCountry,
                     venueCapacity = it.venueCapacity,
                     venueName = it.venueName,
                     imageUrl = it.imageUrl
                 )
             }
         }



}