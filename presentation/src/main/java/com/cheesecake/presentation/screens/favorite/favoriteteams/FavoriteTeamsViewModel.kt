package com.cheesecake.presentation.screens.favorite.favoriteteams


import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageSeasonUseCase
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavoriteTeamsViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val manageSeasonUseCase: ManageSeasonUseCase,
) : BaseViewModel<FavoriteTeamUiState, FavoriteTeamsNavigationEvent>(
    FavoriteTeamUiState(),
    Event()
) {
    private val _season: MutableStateFlow<String> = MutableStateFlow("2024")
    private val season: StateFlow<String> = _season.asStateFlow()

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
        _event.update { Event(FavoriteTeamsNavigationEvent.NavigateToTeam(teamId, season.value)) }
    }

    private fun toggleFavorite(teamId: Int) {
        tryToExecute({ manageTeamsUseCase.favoriteTeam(teamId) }, ::onFavoriteSuccess)
    }

    private fun onFavoriteSuccess(team: Team) {}

    override fun getData() {
        tryToExecute({ manageTeamsUseCase.getFavoriteTeams() }, ::onSuccess)
        collectFlow(manageSeasonUseCase.getSeason()) { season ->
            _season.update { season }
            copy()
        }
    }
}