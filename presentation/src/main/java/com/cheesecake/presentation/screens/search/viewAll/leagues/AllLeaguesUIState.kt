package com.cheesecake.presentation.screens.search.viewAll.leagues

import com.cheesecake.presentation.models.UIStateError
import com.cheesecake.presentation.screens.search.LeagueSearchUIState

data class AllLeaguesUIState(
    val isLoading: Boolean = false,
    val items: List<LeagueSearchUIState> = emptyList(),
    val error: List<UIStateError> = emptyList()

)

