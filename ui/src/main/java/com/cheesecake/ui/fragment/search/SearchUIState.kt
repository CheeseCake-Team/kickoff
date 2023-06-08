package com.cheesecake.ui.fragment.search

import com.cheesecake.ui.models.TeamUIState
import com.cheesecake.ui.models.UIStateError

data class SearchUIState(
    val searchInput: String = "",
    val searchTypes: SearchType? = null,
    val searchResult: List<TeamUIState> = emptyList(),
    val isLoading: Boolean = false,
    val error: List<UIStateError> = emptyList()
)





