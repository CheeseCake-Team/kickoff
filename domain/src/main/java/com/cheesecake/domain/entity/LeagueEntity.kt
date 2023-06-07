package com.cheesecake.domain.entity

data class LeagueEntity(
    val leagueId: Int,
    val leagueName: String,
    val leagueLogo: String,
    val leagueSeason: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val isFavourite: Boolean = false
)