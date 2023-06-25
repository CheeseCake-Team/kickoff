package com.cheesecake.presentation.screens.search.models

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.models.TeamUIState

data class TeamSearchUIState(
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val onClick: () -> Unit ,
)

fun Team.toSearchUIState(onClick: () -> Unit): TeamSearchUIState {
    return TeamSearchUIState(
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        onClick = onClick
    )
}

fun List<Team>.toSearchUIState(onClick: (Team) -> Unit): List<TeamSearchUIState> {
    return this.map {it.toSearchUIState { onClick(it)}}
}

fun Team.toTeamUIState(onClick: () -> Unit): TeamSearchUIState {
    return TeamSearchUIState(
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        onClick = onClick
    )
}