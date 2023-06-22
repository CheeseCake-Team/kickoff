package com.cheesecake.presentation.models


data class TeamUIState (
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val onTeamClick: () -> Unit
)
