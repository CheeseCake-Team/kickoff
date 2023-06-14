package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.ui.favoriteLeagues.FavoriteLeagueUIState

@JvmName("leagueToLeagueUIState")
fun League.toUI(function: () -> Unit): FavoriteLeagueUIState =
    FavoriteLeagueUIState(
        id = this.leagueId,
        leagueName = this.leagueName,
        leagueCountry = this.country,
        imageUrl = this.leagueLogo,
        onFavorite = function,
        isFavourite = this.isFavourite,
    )

