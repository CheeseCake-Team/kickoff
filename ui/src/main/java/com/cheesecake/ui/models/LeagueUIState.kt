package com.cheesecake.ui.models

data class LeagueUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val seasonStartEndYear: String = "",
    val imageUrl: String = "",
    val leagueName: String = "",
    val isFavourite: Boolean = false
)