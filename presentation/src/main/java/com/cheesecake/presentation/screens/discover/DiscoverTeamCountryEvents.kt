package com.cheesecake.presentation.screens.discover

sealed interface DiscoverTeamCountryEvents {
    data class NavigateToCountry(val CountryName: String, val imageUrl: String): DiscoverTeamCountryEvents
}