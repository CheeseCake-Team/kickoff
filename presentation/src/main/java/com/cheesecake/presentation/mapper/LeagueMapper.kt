package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favorite.favoriteLeagues.FavoriteLeagueUIState
import com.cheesecake.presentation.screens.league.LeagueUIState

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

@JvmName("leagueToLeagueUIState")
fun League.toUIState(
    onFavoriteButtonClick: () -> Unit,
    onBackClick: () -> Unit
): LeagueUIState =
    LeagueUIState(
        leagueId = this.leagueId,
        leagueName = this.name,
        seasonStartEndYear = "${this.seasonStartYear}/${this.seasonEndYear}",
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
        onLeagueFavoriteClick = onFavoriteButtonClick,
        OnBackClick = onBackClick,
    )
