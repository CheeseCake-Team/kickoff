package com.cheesecake.ui.fragment.teamstatistics

import androidx.lifecycle.ViewModel
import com.cheesecake.domain.entity.TeamEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class TeamStatisticsUIState(
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