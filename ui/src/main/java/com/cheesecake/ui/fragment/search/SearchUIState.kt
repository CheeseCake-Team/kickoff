package com.cheesecake.ui.fragment.search

import com.cheesecake.ui.models.TeamUIState

data class SearchUIState(
    val searchInput: String = "",
    val searchTypes: SearchType? = null,
    val searchResult: List<TeamUIState> = emptyList(),
    val isLoading: Boolean = false,
    val errors: List<Error> = emptyList()
)

data class Error(
    val code: Int,
    val message: String
)



