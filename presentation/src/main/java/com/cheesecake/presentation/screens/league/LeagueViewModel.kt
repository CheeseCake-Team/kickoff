package com.cheesecake.presentation.screens.league

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase,
    private val leagueArgs :LeagueNavigationArgs,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<LeagueUIState, LeagueNavigationEvent>(LeagueUIState(), Event()) {

//    private val leagueArgs = LeagueNavigationArgs(savedStateHandle)

    private val _leagueId = MutableStateFlow(leagueArgs.leagueId)
    val leagueId: StateFlow<Int> = _leagueId

    init {
        tryToExecute(
            { getLeagueByIdAndSeasonUseCase(leagueArgs.leagueId, leagueArgs.season) },
            ::onSuccess,
            ::onError
        )
    }

    private fun toggleFavourite(leagueId: Int, leagueSeason: Int) {
        viewModelScope.launch {
            favouriteLeagueUseCase(leagueId, leagueSeason).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }


    private fun onSuccess(league: League) {
        league.let {
            _state.update { leagueUiState ->
                leagueUiState.copy(
                    leagueId = it.leagueId,
                    leagueSeason = it.season.toInt(),
                    leagueName = it.name,
                    seasonStartEndYear = "${it.seasonStartYear}/${it.seasonEndYear}",
                    imageUrl = it.imageUrl,
                    isFavourite = it.isFavourite,
                    onLeagueFavoriteClick = { leagueId, leagueSeason ->
                        toggleFavourite(
                            leagueId,
                            leagueSeason
                        )
                    },
                    onBackClick = { onBackClick() }
                )
            }


        }
    }

    private fun onBackClick() {
        _event.update { Event(LeagueNavigationEvent.NavigateBack) }
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
