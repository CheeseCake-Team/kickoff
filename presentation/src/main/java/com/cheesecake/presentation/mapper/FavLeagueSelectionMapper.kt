package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.screens.favLeaguesSelection.FavLeagueItemUIState

    @JvmName("leagueToLeaguesUIState")
    fun League.toFavLeagueItemUIState(
        selectedLeagues: List<League>,
        onFavoriteLeagueClick: () -> Unit
    ): FavLeagueItemUIState {
        val isSelected = selectedLeagues.contains(this)
        return FavLeagueItemUIState(
            imageUrl = this.leagueLogo,
            leagueName = this.leagueName,
            isSelected = isSelected,
            onFavorite = onFavoriteLeagueClick
        )
    }
