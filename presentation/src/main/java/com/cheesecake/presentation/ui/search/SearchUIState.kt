package com.cheesecake.presentation.ui.search

import com.cheesecake.presentation.models.TeamUIState
import com.cheesecake.presentation.models.UIStateError

data class SearchUIState(
    val searchInput: String = "",
    val searchTypes: SearchType? = null,
    val searchResult: List<TeamUIState>? = null,
    val isLoading: Boolean = false,
    val error: List<UIStateError> = emptyList()
)





