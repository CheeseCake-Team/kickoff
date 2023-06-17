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
        season = this.season,
        country = this.country,
        typeName = this.typeName,
        seasonStartYear = this.seasonStartYear,
        seasonEndYear = this.seasonEndYear,
        isSelected = this.isFavourite,
        onFavorite = onFavoriteLeagueClick
    )
}

fun FavLeagueItemUIState.toLeague(): League{
    return League(
        leagueId = this.leagueId,
        imageUrl = this.imageUrl,
        name = this.leagueName,
        season = this.season,
        country = this.country,
        typeName = this.typeName,
        seasonStartYear = this.seasonStartYear,
        seasonEndYear = this.seasonEndYear,
        isFavourite = isSelected
    )
}