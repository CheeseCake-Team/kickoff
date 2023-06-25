package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favLeaguesSelection.FavLeagueItemUIState

@JvmName("leagueToLeaguesUIState")
fun League.toFavLeagueItemUIState(
    onFavoriteLeagueClick: (Int) -> Unit
): FavLeagueItemUIState {
    return FavLeagueItemUIState(
        leagueId = this.leagueId,
        imageUrl = this.imageUrl,
        leagueName = this.name,
        isSelected = this.isFavourite,
        onFavorite = { onFavoriteLeagueClick(this.leagueId) }
    )
}
