package com.cheesecake.presentation.screens.country.countryTeams

sealed interface CountryTeamsNavigationEvent {
    data class NavigateToTeam(val teamId: Int) : CountryTeamsNavigationEvent

}