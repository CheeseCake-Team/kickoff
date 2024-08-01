package com.cheesecake.presentation.screens.favorite.favoriteteams


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
) : BaseViewModel<FavoriteTeamUiState, FavoriteTeamsNavigationEvent>(
    FavoriteTeamUiState(),
    Event()
) {
    init {
        getData()
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
        tryToExecute({ manageTeamsUseCase.favoriteTeam(teamId) }, ::onFavoriteSuccess)
    }

    private fun onFavoriteSuccess(team: Team) {}

    override fun getData() {
        tryToExecute({ manageTeamsUseCase.getFavoriteTeams() }, ::onSuccess)
    }
}