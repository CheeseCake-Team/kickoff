package com.cheesecake.presentation.screens.team

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTeamByIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.screens.league.LeagueUIState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class TeamViewModel @Inject constructor(
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
) : BaseViewModel<TeamUiState>(TeamUiState()) {

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