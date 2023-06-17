package com.cheesecake.presentation.screens.favorite.favoriteTeams

import com.cheesecake.domain.entity.Team

data class FavoriteTeamUIState(
    val teams: List<FavoriteTeamItemUiState> = emptyList(),
    val isTeamsIsEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
