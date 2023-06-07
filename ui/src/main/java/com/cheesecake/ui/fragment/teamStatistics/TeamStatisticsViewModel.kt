package com.cheesecake.ui.fragment.teamstatistics

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.models.TeamEntity
import com.cheesecake.domain.usecases.fixture.GetSingleFixtureByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TeamStatisticsUIState (
    val isLoading: Boolean = true,
    val data: List<TeamEntity> = emptyList(),
    val isError: String = "Error"
)

@HiltViewModel
class TeamStatisticsViewModel @Inject constructor(
) : ViewModel() {

    private val _teamStatisticsUIState = MutableStateFlow(TeamStatisticsUIState())
    val teamStatisticsUIState = _teamStatisticsUIState.asStateFlow()



}
