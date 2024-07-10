package com.cheesecake.presentation.screens.competition

sealed interface CompetitionNavigationEvent {
    object NavigateBack: CompetitionNavigationEvent
}