package com.cheesecake.presentation.ui.favoriteTeams


import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.GetFavoriteTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteTeamsViewModel @Inject constructor(
    private val getFavoriteTeamsUseCase: GetFavoriteTeamsUseCase
) : BaseViewModel<FavoriteTeamUIState>(FavoriteTeamUIState()) {

    init {
        getFavoriteTeams()
    }

    private fun getFavoriteTeams() {
        tryToExecute({ getFavoriteTeamsUseCase() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<Team>>) {
        viewModelScope.launch {
            flow.collect { teams ->
                _state.update { it.copy(teams = teams, isTeamsIsEmpty = teams.isEmpty(),isLoading = false) }
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false) }
    }

}