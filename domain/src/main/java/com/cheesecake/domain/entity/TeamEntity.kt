package com.cheesecake.domain.entity

data class TeamEntity(
    val teamId: Int,
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val isFavourite: Boolean,
    val matchesPlayed: Int?,
    val matchesWins: Int?,
    val matchesDraws: Int?,
    val matchesLoses: Int?,
    val teamPoints: Int?
)
