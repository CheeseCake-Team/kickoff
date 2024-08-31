package com.cheesecake.domain.entity

data class League(
    val competitionId: Int,
    val name: String,
    val imageUrl: String,
    val season: List<Int>,
    val countryName: String,
    val leagueTypeName: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val leagueCount: Int,
    val isFavourite: Boolean = false
)
