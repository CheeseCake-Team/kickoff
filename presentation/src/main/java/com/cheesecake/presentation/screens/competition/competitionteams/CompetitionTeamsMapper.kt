package com.cheesecake.presentation.screens.competition.competitionteams

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.models.TeamUIState

fun List<Team>.toUiState(onclick: (Int) -> Unit): List<TeamUIState> {
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