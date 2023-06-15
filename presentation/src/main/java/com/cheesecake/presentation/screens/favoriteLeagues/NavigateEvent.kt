package com.cheesecake.presentation.screens.favoriteLeagues


sealed interface NavigateEvent {
    data class NavigateToLeague(val leagueId: Int) : NavigateEvent
}