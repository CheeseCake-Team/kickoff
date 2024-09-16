package com.cheesecake.presentation.screens.search.viewAll.teams

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class TeamsSearchNavigationArgs @Inject constructor(state: SavedStateHandle) {
    private val args = state.let {
        TeamsSearchFragmentArgs.fromSavedStateHandle(it)
    }
    val searchQuery = args.searchQuery
    val season = args.season
}