package com.cheesecake.presentation.screens.league.leagueTeams

import com.cheesecake.presentation.models.TeamUIState

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
//    val onclick: () -> Unit = {},
)
