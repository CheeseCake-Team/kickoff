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
    val teamsCount: Int
//    val onclick: () -> Unit = {},
)

fun Team.toSearchUIState(): TeamSearchUIState {
    return TeamSearchUIState(
        teamId = this.id,
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
        teamsCount = 0
    )
}