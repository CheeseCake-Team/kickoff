package com.cheesecake.presentation.screens.search.viewAll.competitions

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class CompetitionsSearchNavigationArgs @Inject constructor(state: SavedStateHandle) {
    private val args = state.let {
        CompetitionsSearchFragmentArgs.fromSavedStateHandle(it)
    }
    val searchQuery = args.searchQuery
}