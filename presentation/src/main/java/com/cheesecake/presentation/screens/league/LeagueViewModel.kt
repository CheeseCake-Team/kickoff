package com.cheesecake.presentation.screens.league

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase,
    private val leagueArgs: LeagueNavigationArgs,
) : BaseViewModel<LeagueUIState, LeagueNavigationEvent>(LeagueUIState(), Event()) {

    val leagueId = leagueArgs.leagueId

    init {
        initData()
    }

    private fun initData() {
        tryToExecute(
            { getLeagueByIdAndSeasonUseCase(leagueArgs.leagueId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(league: League) {
        _state.update { leagueUiState ->
            leagueUiState.copy(
                leagueId = league.leagueId,
                leagueSeason = league.season.last(),
                leagueName = league.name,
                seasonStartEndYear = "${league.seasonStartYear}/${league.seasonEndYear}",
                imageUrl = league.imageUrl,
                isFavourite = league.isFavourite,
                onLeagueFavoriteClick = { leagueId ->
                    toggleFavourite(
                        leagueId,
                    )
                },
                onBackClick = { onBackClick() }
            )
        }
        Log.i("initdscdsdcsdvvs: ", state.value.leagueSeason.toString())
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.message ?: "Unknown error.",
                isLoading = false
            )
        }

    }

    private fun toggleFavourite(leagueId: Int) {
        viewModelScope.launch {
            favouriteLeagueUseCase(leagueId).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }

    private fun onBackClick() {
        _event.update { Event(LeagueNavigationEvent.NavigateBack) }
    }

}
