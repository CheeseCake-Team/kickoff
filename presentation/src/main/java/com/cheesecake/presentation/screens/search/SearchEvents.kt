package com.cheesecake.presentation.screens.search

sealed interface SearchEvents{
    object LeagueClickEvent : SearchEvents
    object TeamClickEvent : SearchEvents
}