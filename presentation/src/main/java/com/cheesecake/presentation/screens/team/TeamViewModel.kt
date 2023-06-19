package com.cheesecake.presentation.screens.team

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetTeamByIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
) : BaseViewModel<TeamUIState, TeamNavigationEvent>(TeamUIState(), Event()) {

    init {
        getTeam()
    }

    private fun getTeam() {
        viewModelScope.launch {
            getTeamByIdUseCase(34).let { team ->
                _state.update { uiState ->
                    uiState.copy(
                        imageUrl = team.imageUrl,
                        teamName = team.name,
                        country = team.country
                    )
                }
            }
        }
    }
}