package com.cheesecake.presentation.screens.match

import androidx.lifecycle.SavedStateHandle

class MatchArgs(savedStateHandle: SavedStateHandle) {
    val matchId: String = savedStateHandle[MATCH_ID_ARG]
        ?: MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).matchId

    val date: String = savedStateHandle[MATCH_DATE_ARG]
        ?: MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).data


    companion object {
        const val MATCH_ID_ARG = "matchID"
        const val MATCH_DATE_ARG = "matchDate"
    }
}
