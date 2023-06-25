package com.cheesecake.presentation.screens.team

import com.cheesecake.domain.entity.Team

data class TeamUIState(
    val teamId: Int = 0,
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val imageUrl: String = "",
    val teamName: String = "",
    val country: String = "",
    val isFavourite: Boolean = false,
    val onBackClick: () -> Unit = {},
    val onTeamFavoriteClick: () -> Unit = { }
)

fun Team.toUiState(toggleFavourite: (Int) -> Unit, onBackClick: () -> Unit) = TeamUIState(
    teamId = id,
    teamName = name,
    country = country,
    imageUrl = imageUrl,
    isFavourite = isFavourite,
    onTeamFavoriteClick = { toggleFavourite(id) },
    onBackClick = onBackClick
)