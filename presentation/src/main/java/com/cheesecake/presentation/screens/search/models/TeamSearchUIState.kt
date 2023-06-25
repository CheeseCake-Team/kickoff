package com.cheesecake.presentation.screens.search.models

import com.cheesecake.domain.entity.Team

data class TeamSearchUIState(
    val teamId: Int,
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val isFavourite: Boolean,
    val onClick: () -> Unit ,
)

fun Team.toSearchUIState(onClick: () -> Unit): TeamSearchUIState {
    return TeamSearchUIState(
        teamId = this.id,
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
        onClick = onClick
    )
}

fun List<Team>.toSearchUIState(onClick: (Team) -> Unit): List<TeamSearchUIState> {
    return this.map {it.toSearchUIState { onClick(it)}}
}