package com.cheesecake.presentation.screens.search.models

data class SearchUIState(
    val searchInput: String = "",
    val searchTypes: SearchType? = null,
    val searchResult: List<SearchResult>? = null,
    val isResultEmpty: Boolean = false,
    val isLoading: Boolean = false,
    val error: String = "",
    val onClickSearchBar: (() -> Unit)? = null
)





