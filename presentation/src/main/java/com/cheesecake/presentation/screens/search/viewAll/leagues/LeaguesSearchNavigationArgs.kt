package com.cheesecake.presentation.screens.search.viewAll.leagues

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class LeaguesSearchNavigationArgs @Inject constructor(state: SavedStateHandle) {
    private val args = state.let {
        LeaguesSearchFragmentArgs.fromSavedStateHandle(it)
    }
    val searchQuery = args.searchQuery
    val searchType = args.searchType
}