package com.cheesecake.domain.entity

data class League(
    val leagueId: Int,
    val leagueName: String,
    val leagueLogo: String,
    val leagueSeason: String,
    val country: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val isFavourite: Boolean = false,
    val isSelected: Boolean = false
)