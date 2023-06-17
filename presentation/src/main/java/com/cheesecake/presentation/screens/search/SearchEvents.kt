package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.screens.home.HomeNavigationEvent

sealed interface SearchEvents{
    object LeagueClickEvent : SearchEvents
    object TeamClickEvent : SearchEvents
}