package com.cheesecake.presentation.screens.match.lineup

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.presentation.screens.match.statistics.MatchStatisticsArgs

class MatchLineupsArgs (savedStateHandle: SavedStateHandle) {
    val fixtureId: Int = savedStateHandle[FIXTURE_ID_ARG] ?: 215662
    val state: String = savedStateHandle[MatchStatisticsArgs.FIXTURE_STATUS] ?: " "

    companion object {
        const val FIXTURE_ID_ARG = "matchFixtureId"
        const val FIXTURE_STATUS = "fixturestatus"

    }
}