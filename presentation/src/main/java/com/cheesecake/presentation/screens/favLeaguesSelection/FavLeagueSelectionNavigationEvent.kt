package com.cheesecake.presentation.screens.favLeaguesSelection

sealed interface FavLeagueSelectionNavigationEvent {

    data class NavigateToLeague(val leagueId: Int) : FavLeagueSelectionNavigationEvent
}