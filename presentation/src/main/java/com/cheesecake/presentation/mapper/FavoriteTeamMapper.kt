package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.screens.favorite.favoriteTeams.FavoriteTeamItemUiState


@JvmName("teamToFavoriteTeamItemUiState")
fun Team.toUIState(
    onFavoriteButtonClick: (Int) -> Unit,
    onFavoriteLeagueClick: (Int) -> Unit
): FavoriteTeamItemUiState =
    FavoriteTeamItemUiState(
        teamId = this.id,
        name = this.name,
        country = this.country,
        imageUrl = this.imageUrl,
        isFavorite = this.isFavourite,
        onFavoriteClick = onFavoriteButtonClick,
        onFavoriteTeamClick = onFavoriteLeagueClick,
    )