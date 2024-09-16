package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Competition
import com.cheesecake.presentation.screens.favorite.favoritecompetitions.FavoriteCompetitionsUiState

@JvmName("leagueToLeaguesUIState")
fun Competition.toLeaguesUIState(
    onFavoriteButtonClick: () -> Unit,
    onFavoriteLeagueClick: (Int) -> Unit
): FavoriteCompetitionsUiState =
    FavoriteCompetitionsUiState(
        id = this.competitionId,
        leagueName = this.name,
        leagueCountry = this.countryName,
        imageUrl = this.imageUrl,
        onFavorite = onFavoriteButtonClick,
        onFavoriteLeagueClick = { onFavoriteLeagueClick(this.competitionId) },
    )
