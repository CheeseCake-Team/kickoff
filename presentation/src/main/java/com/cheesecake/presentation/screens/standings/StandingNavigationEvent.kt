package com.cheesecake.presentation.screens.standings

sealed interface StandingNavigationEvent{
    object  NavigateBack: StandingNavigationEvent
}