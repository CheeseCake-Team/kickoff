package com.cheesecake.presentation.screens.favorite.favoriteteams

sealed interface FavoriteTeamsNavigationEvent {
    data class NavigateToTeam(val teamId: Int, val season: String): FavoriteTeamsNavigationEvent
}