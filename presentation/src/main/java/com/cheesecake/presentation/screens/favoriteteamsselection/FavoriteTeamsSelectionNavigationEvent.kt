package com.cheesecake.presentation.screens.favoriteteamsselection

sealed interface FavoriteTeamsSelectionNavigationEvent {
    object NavigateToHome: FavoriteTeamsSelectionNavigationEvent
}