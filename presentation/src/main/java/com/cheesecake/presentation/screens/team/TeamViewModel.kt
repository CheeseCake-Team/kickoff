package com.cheesecake.presentation.screens.team

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageSeasonUseCase
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val manageSeasonUseCase: ManageSeasonUseCase,
    val teamNavigationArgs: TeamNavigationArgs
) : BaseViewModel<TeamUiState, TeamNavigationEvent>(TeamUiState(), Event()) {
    private val _season: MutableStateFlow<String> = MutableStateFlow("2024")
    val season: StateFlow<String> = _season.asStateFlow()

    init {
        getData()
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

    override fun getData() {
        collectFlow(manageSeasonUseCase.getSeason()) { season ->
            _season.update { season }
            copy()
        }
        tryToExecute(
            { manageTeamsUseCase.getTeamById(teamNavigationArgs.teamId) }, ::onGettingTeamSuccess
        )
    }
}