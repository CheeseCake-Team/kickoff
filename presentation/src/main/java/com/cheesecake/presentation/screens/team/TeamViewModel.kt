package com.cheesecake.presentation.screens.team

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.FavouriteTeamUseCase
import com.cheesecake.domain.usecases.GetTeamByIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val favouriteTeamUseCase: FavouriteTeamUseCase,
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
    val teamNavigationArgs: TeamNavigationArgs
) : BaseViewModel<TeamUIState, TeamNavigationEvent>(TeamUIState(), Event()) {

    init {
        tryToExecute(
            { getTeamByIdUseCase(teamNavigationArgs.teamId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun toggleFavourite(teamId: Int) {
        viewModelScope.launch {
            favouriteTeamUseCase(teamId).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }

    private fun onSuccess(team: Team) {
        _state.update { teamUiState ->
            teamUiState.copy(
                teamId = team.id,
                teamName = team.name,
                country = team.country,
                imageUrl = team.imageUrl,
                isFavourite = team.isFavourite,
                onTeamFavoriteClick = { toggleFavourite(team.id) },
                onBackClick = { onBackClick() }
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
