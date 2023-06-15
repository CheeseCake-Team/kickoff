package com.cheesecake.presentation.screens.favoriteLeagues


sealed interface FavoriteLeaguesNavigationEvent {
    data class NavigateToLeague(val leagueId: Int) : FavoriteLeaguesNavigationEvent
}