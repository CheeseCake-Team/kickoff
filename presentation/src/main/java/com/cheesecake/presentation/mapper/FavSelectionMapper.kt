package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.screens.favLeaguesSelection.FavLeagueItemUIState
import com.cheesecake.presentation.screens.favTeamsSelection.FavTeamItemUIState

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

@JvmName("teamToTeamsUIState")
fun Team.toFavTeamItemUIState(
    onFavoriteTeamClick: (Int) -> Unit
): FavTeamItemUIState {
    return FavTeamItemUIState(
        teamId = this.id,
        imageUrl = this.imageUrl,
        teamName = this.name,
        isSelected = this.isFavourite,
        onFavorite = { onFavoriteTeamClick(this.id) }
    )
}

