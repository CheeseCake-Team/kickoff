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
    val leagueMatchesPlayed: Int?,
    val leagueWins: Int?,
    val leagueDraws: Int?,
    val leagueLoses: Int?,
    val leaguePoints: Int?
)
