package com.cheesecake.presentation.screens.league.leagueTeams

import com.cheesecake.domain.entity.Team


data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)

data class TeamUIState(
    val teamId: Int,
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val isFavourite: Boolean,
    val onclick: () -> Unit = {},
)


fun List<Team>.toUIState(onclick: (Int) -> Unit): List<TeamUIState> {
    return map {
        TeamUIState(
            teamId = it.id,
            teamName = it.name,
            founded = it.yearFounded,
            teamCountry = it.country,
            venueCapacity = it.stadiumCapacity,
            venueName = it.stadiumName,
            imageUrl = it.imageUrl,
            isFavourite = it.isFavourite,
            onclick = { onclick(it.id) }
        )
    }
}

