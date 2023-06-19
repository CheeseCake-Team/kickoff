package com.cheesecake.presentation.screens.match.lineup

import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event

class MatchLineupViewModel : BaseViewModel<MatchLineupUIState, MatchLineupEvents>(
    MatchLineupUIState(),
    Event()
) {
}