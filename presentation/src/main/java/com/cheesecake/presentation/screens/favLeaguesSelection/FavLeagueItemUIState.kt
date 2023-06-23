package com.cheesecake.presentation.screens.favLeaguesSelection

data class FavLeagueItemUIState(
    val leagueId : Int = 0,
    val imageUrl: String = "",
    val leagueName: String = "",
    val season: String = "",
    val country: String = "",
    val typeName: String= "",
    val seasonStartYear: String= "",
    val seasonEndYear: String ="",
    val leagueCount: Int = 0,
    val isSelected: Boolean = false,
    val onFavorite: (Int) -> Unit,
)