package com.cheesecake.domain.models

data class League(
    val leagueId: Int,
    val leagueName: String,
    val leagueLogo: String,
    val leagueSeason: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val isFavourite: Boolean = false
)