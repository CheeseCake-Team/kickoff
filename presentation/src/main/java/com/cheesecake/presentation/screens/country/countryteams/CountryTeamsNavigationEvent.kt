package com.cheesecake.presentation.screens.country.countryteams

sealed interface CountryTeamsNavigationEvent {
    data class NavigateToTeam(val teamId: Int) : CountryTeamsNavigationEvent

}