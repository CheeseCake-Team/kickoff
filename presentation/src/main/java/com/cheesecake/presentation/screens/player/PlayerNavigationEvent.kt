package com.cheesecake.presentation.screens.player


sealed interface PlayerNavigationEvent {

    object NavigateBack: PlayerNavigationEvent
}