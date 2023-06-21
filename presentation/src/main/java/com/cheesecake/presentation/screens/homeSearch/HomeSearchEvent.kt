package com.cheesecake.presentation.screens.homeSearch

sealed interface HomeSearchEvent {

    data class RecentClickSearchEvent(val recent: RecentSearchUIState) : HomeSearchEvent

    data class PlayerClickSearchEvent(val id: Int, val season: Int) : HomeSearchEvent

}