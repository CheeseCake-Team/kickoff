package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favoriteLeagues.FavoriteLeagueUIState
import com.cheesecake.presentation.screens.league.LeagueUIState

@JvmName("leagueToLeaguesUIState")
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

@JvmName("leagueToLeagueUIState")
fun League.toUIState(
    onFavoriteButtonClick: () -> Unit,
    onBackClick: () -> Unit
): LeagueUIState =
    LeagueUIState(
        leagueId = this.leagueId,
        leagueName = this.leagueName,
        seasonStartEndYear = "${this.seasonStartYear}/${this.seasonEndYear}",
        imageUrl = this.leagueLogo,
        isFavourite = this.isFavourite,
        onLeagueFavoriteClick = onFavoriteButtonClick,
        OnBackClick = onBackClick,
    )
