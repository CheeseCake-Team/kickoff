package com.cheesecake.ui.fragment.search

data class SearchUIState(
    val searchInput: String,
    val searchType: SearchType,
    val searchResult: List<SearchResult>
)



