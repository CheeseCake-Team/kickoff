package com.cheesecake.presentation.screens.country.countryLeagues

sealed interface CountryLeaguesNavigationEvent {

    data class NavigateToLeague(val leagueId: Int): CountryLeaguesNavigationEvent

}