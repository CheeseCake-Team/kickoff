package com.cheesecake.ui.fragment.teamstatistics

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class TeamStatisticsViewModel @Inject constructor(
) : ViewModel() {

    private val _teamStatisticsUIState = MutableStateFlow(TeamStatisticsUIState())
    val teamStatisticsUIState = _teamStatisticsUIState.asStateFlow()


}