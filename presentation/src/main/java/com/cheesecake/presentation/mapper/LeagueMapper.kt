package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favorite.favoriteLeagues.FavoriteLeagueUIState

@JvmName("leagueToLeaguesUIState")
fun League.toLeaguesUIState(
    onFavoriteButtonClick: () -> Unit,
    onFavoriteLeagueClick: (Int) -> Unit
): FavoriteLeagueUIState =
    FavoriteLeagueUIState(
        id = this.leagueId,
        leagueName = this.name,
        leagueCountry = this.country,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
        onFavorite = onFavoriteButtonClick,
        onFavoriteLeagueClick = onFavoriteLeagueClick,
    )
