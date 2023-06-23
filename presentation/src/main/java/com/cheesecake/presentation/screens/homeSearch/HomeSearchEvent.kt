package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.presentation.screens.search.SearchEvents

sealed interface HomeSearchEvent {
    data class RecentClickEvent(val recent: RecentSearchUIState) : HomeSearchEvent
    data class PlayerClickEvent(val id: Int, val season: Int) : HomeSearchEvent
    object SearchBarClick: HomeSearchEvent


}