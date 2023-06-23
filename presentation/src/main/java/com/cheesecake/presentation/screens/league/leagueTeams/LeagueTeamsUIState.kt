package com.cheesecake.presentation.screens.league.leagueTeams

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.models.TeamUIState


data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)




fun List<Team>.toUIState(onclick: (Int) -> Unit): List<TeamUIState> {
    return map {
        TeamUIState(
            teamName = it.name,
            founded = it.yearFounded,
            teamCountry = it.country,
            venueCapacity = it.stadiumCapacity,
            venueName = it.stadiumName,
            imageUrl = it.imageUrl,
            onTeamClick = { onclick(it.id) }
        )
    }
}

