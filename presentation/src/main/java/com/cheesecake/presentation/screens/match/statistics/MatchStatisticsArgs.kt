package com.cheesecake.presentation.screens.match.statistics

import androidx.lifecycle.SavedStateHandle

class MatchStatisticsArgs(savedStateHandle: SavedStateHandle) {
    val fixtureId: Int = savedStateHandle[FIXTURE_ID_ARG] ?: 215662
    val state: String = savedStateHandle[FIXTURE_STATUS] ?: " "

    companion object {
        const val FIXTURE_ID_ARG = "matchFixtureId"
        const val FIXTURE_STATUS = "fixturestatus"
    }
}