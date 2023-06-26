package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.RecentSearch

sealed interface HomeSearchEvent {
    data class RecentClickEvent(val recent: RecentSearch) : HomeSearchEvent
    object SearchBarClick: HomeSearchEvent


}