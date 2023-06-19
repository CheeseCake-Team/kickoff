package com.cheesecake.presentation.screens.team

sealed interface TeamNavigationEvent {
    object NavigateBack: TeamNavigationEvent
}