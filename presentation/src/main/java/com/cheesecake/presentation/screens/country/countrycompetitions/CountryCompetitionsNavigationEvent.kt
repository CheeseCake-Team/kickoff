package com.cheesecake.presentation.screens.country.countrycompetitions

sealed interface CountryCompetitionsNavigationEvent {
    data class NavigateToCompetition(val competitionId: Int): CountryCompetitionsNavigationEvent
}