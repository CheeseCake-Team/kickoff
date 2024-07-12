package com.cheesecake.presentation.screens.team

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    val teamNavigationArgs: TeamNavigationArgs
) : BaseViewModel<TeamUiState, TeamNavigationEvent>(TeamUiState(), Event()) {
    init {
        tryToExecute(
            { manageTeamsUseCase.getTeamById(teamNavigationArgs.teamId) },
            ::onGettingTeamSuccess,
            ::onError
        )
    }

    fun onFavoriteClick() {
        viewModelScope.launch {
            manageTeamsUseCase.favoriteTeam(teamNavigationArgs.teamId).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }

    private fun onGettingTeamSuccess(team: Team) {
        _state.update { teamUiState ->
            teamUiState.copy(
                teamName = team.name,
                country = team.country,
                imageUrl = team.imageUrl,
                isFavourite = team.isFavourite,
            )
        }
    }

    fun onBackClick() {
        _event.update { Event(TeamNavigationEvent.NavigateBack) }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }
}