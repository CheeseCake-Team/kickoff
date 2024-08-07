package com.cheesecake.presentation.screens.favorite.favoriteTeams


import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavoriteTeamsViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
) : BaseViewModel<FavoriteTeamUIState, FavoriteTeamsNavigationEvent>(
    FavoriteTeamUIState(),
    Event()
) {
    init {
        getFavoriteTeams()
    }

    private fun getFavoriteTeams() {
        tryToExecute({ manageTeamsUseCase.getFavoriteTeams() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<Team>>) {
        collectFlow(flow) { teams ->
            copy(
                teams = teams.map { team ->
                    team.toUIState({ toggleFavorite(team.id) }, { navigateToTeamFragment(team.id) })
                },
                isTeamsIsEmpty = teams.isEmpty(),
                isLoading = false
            )
        }
    }

    private fun navigateToTeamFragment(teamId: Int) {
        _event.update { Event(FavoriteTeamsNavigationEvent.NavigateToTeam(teamId, 2022)) }
    }

    private fun toggleFavorite(teamId: Int) {
        tryToExecute({ manageTeamsUseCase.favoriteTeam(teamId) }, ::onFavoriteSuccess, ::onError)
    }

    private fun onFavoriteSuccess(team: Team) {}

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }
}