package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favoriteLeagues.FavoriteLeagueUIState

@JvmName("leagueToLeagueUIState")
fun League.toUIState(
    onFavoriteButtonClick: () -> Unit,
    onFavoriteLeagueClick: (Int) -> Unit
): FavoriteLeagueUIState =
    FavoriteLeagueUIState(
        id = this.leagueId,
        leagueName = this.leagueName,
        leagueCountry = this.country,
        imageUrl = this.leagueLogo,
        isFavourite = this.isFavourite,
        onFavorite = onFavoriteButtonClick,
        onFavoriteLeagueClick = onFavoriteLeagueClick,
    )

