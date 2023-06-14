package com.cheesecake.presentation.screens.favoriteTeams

import com.cheesecake.domain.entity.Team

data class FavoriteTeamUIState(
    val teams: List<Team> = emptyList(),
    val isTeamsIsEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
