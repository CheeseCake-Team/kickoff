package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.models.UIStateError

data class SearchUIState(
    val searchInput: String = "",
    val searchTypes: SearchType? = null,
    val searchResult: List<SearchResult>? = null,
    val isLoading: Boolean = false,
    val error: List<UIStateError> = emptyList()
)





