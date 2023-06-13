package com.cheesecake.presentation.ui.favoriteLeagues

import com.cheesecake.domain.entity.League

data class FavoriteLeagueUIState(
    val leagues: List<League> = emptyList(),
    val isLeaguesIsEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
