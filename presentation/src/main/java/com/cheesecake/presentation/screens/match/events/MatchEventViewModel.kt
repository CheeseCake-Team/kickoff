package com.cheesecake.presentation.screens.match.events

import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event

class MatchEventViewModel : BaseViewModel<MatchEventUIState, MatchEventEvents>(
    MatchEventUIState(),
    Event()
) {
}