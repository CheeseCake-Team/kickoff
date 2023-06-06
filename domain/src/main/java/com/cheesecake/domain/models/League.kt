package com.cheesecake.domain.models

data class League(
    val leagueName: String,
    val leagueSeason: String,
    val leagueLogo: String,
    val isFavourite: Boolean = false
)