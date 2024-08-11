package com.cheesecake.presentation.screens.search.models

import com.cheesecake.domain.entity.Team

data class TeamSearchItemUiState(
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val onClick: () -> Unit ,
)

fun Team.toSearchUIState(onClick: () -> Unit): TeamSearchItemUiState {
    return TeamSearchItemUiState(
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        onClick = onClick
    )
}

fun List<Team>.toSearchUIState(onClick: (Team) -> Unit): List<TeamSearchItemUiState> {
    return this.map {it.toSearchUIState { onClick(it)}}
}

fun Team.toTeamUIState(onClick: () -> Unit): TeamSearchItemUiState {
    return TeamSearchItemUiState(
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        onClick = onClick
    )
}