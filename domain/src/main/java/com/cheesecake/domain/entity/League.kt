package com.cheesecake.domain.entity

data class League(
    val leagueId: Int,
    val name: String,
    val imageUrl: String,
    val season: String,
    val country: String,
    val typeName: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val isFavourite: Boolean = false,
    val isSelected: Boolean = false
)