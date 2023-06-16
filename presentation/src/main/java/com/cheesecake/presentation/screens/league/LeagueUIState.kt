package com.cheesecake.presentation.screens.league

data class LeagueUIState(
    val leagueId: Int = 0,
    val leagueSeason: Int = 0,
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val seasonStartEndYear: String = "",
    val imageUrl: String = "",
    val leagueName: String = "",
    val isFavourite: Boolean = false,
    val onBackClick: () -> Unit = {},
    val onLeagueFavoriteClick: (Int, Int)-> Unit = {i, s -> }
)