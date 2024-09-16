package com.cheesecake.presentation.screens.favorite.favoritecompetitions

sealed interface FavoriteCompetitionsNavigationEvent {
    data class NavigateToCompetition(val competitionId: Int) : FavoriteCompetitionsNavigationEvent
}