package com.cheesecake.presentation.screens.home

sealed interface HomeNavigationEvent {
    object MatchClickedEvent : HomeNavigationEvent
    object LeagueClickEvent : HomeNavigationEvent
}