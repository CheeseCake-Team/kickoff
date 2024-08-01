package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favorite.favoritecompetitions.FavoriteCompetitionsUiState

@JvmName("leagueToLeaguesUIState")
fun League.toLeaguesUIState(
    onFavoriteButtonClick: () -> Unit,
    onFavoriteLeagueClick: (Int) -> Unit
): FavoriteCompetitionsUiState =
    FavoriteCompetitionsUiState(
        id = this.leagueId,
        leagueName = this.name,
        leagueCountry = this.countryName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
        onFavorite = onFavoriteButtonClick,
        onFavoriteLeagueClick = { onFavoriteLeagueClick(this.leagueId) },
    )
