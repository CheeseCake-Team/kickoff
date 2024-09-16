package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.screens.favorite.favoriteteams.FavoriteTeamItemUiState


@JvmName("teamToFavoriteTeamItemUiState")
fun Team.toUIState(
    onFavoriteButtonClick: (Int) -> Unit,
    onFavoriteLeagueClick: (Int) -> Unit
): FavoriteTeamItemUiState {
    return FavoriteTeamItemUiState(
        teamId = this.id,
        name = this.name,
        country = this.country ?: "Unknown",
        imageUrl = this.imageUrl,
        isFavorite = this.isFavourite,
        onFavoriteClick = { onFavoriteButtonClick(this.id) },
        onFavoriteTeamClick = { onFavoriteLeagueClick(this.id) },
    )
}