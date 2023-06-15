package com.cheesecake.presentation.screens.league

sealed interface LeagueNavigationEvent {

    object NavigateBack: LeagueNavigationEvent

}