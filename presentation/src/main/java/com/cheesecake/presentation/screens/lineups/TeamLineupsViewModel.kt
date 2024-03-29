package com.cheesecake.presentation.screens.lineups

import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TeamLineupsViewModel @Inject constructor() : BaseViewModel<TeamLineupsUiState,TeamLineupEvent>(
    TeamLineupsUiState(), Event()
)


