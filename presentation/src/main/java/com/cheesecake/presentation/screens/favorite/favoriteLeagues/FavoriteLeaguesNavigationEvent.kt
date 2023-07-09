package com.cheesecake.presentation.screens.favorite.favoriteLeagues


sealed interface FavoriteLeaguesNavigationEvent {
    data class NavigateToLeague(val leagueId: Int) : FavoriteLeaguesNavigationEvent
}