package com.cheesecake.presentation.screens.favoriteTeams

sealed interface FavoriteTeamsNavigationEvent {

    data class NavigateToTeam(val teamId: Int, val season: Int): FavoriteTeamsNavigationEvent

}