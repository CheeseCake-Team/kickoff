package com.cheesecake.presentation.models

import com.cheesecake.domain.entity.Team

data class TeamUIState (
    val teamId: Int,
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val isFavourite: Boolean,
)
