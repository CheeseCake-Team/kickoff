package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetFavoriteLeaguesMatchesByDateUseCase
import com.cheesecake.domain.usecases.DateManager
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dateManager: DateManager,
    private val getFavoriteLeagueMatchesByDate: GetFavoriteLeaguesMatchesByDateUseCase,
) : BaseViewModel<HomeUiState, HomeEvents>(HomeUiState(), Event()) {
    init {
        getDates()
        getMatchesByDate(dateManager.getToday())
    }

    private fun getDates() {
        dateManager.getDatesInRange(-30 until 30).toUiState { onDateClick(it) }.also {
            _state.update { homeUiState ->
                homeUiState.copy(
                    dateItems = it,
                    currentDatePosition = it.indexOfFirst { dateItemUIState -> dateItemUIState.isSelected })
            }
        }
    }

    private fun onDateClick(date: Date) {
        _state.update {
            val dateItems = it.dateItems.map { dateItemUiState ->
                if (dateItemUiState.date == date) {
                    dateItemUiState.copy(isSelected = true)
                } else {
                    dateItemUiState.copy(isSelected = false)
                }
            }
            it.copy(
                isLoading = true,
                dateItems = dateItems,
                currentDatePosition = dateItems.indexOfFirst { dateItemUIState -> dateItemUIState.isSelected }
            )
        }
        getMatchesByDate(date)
    }

    private fun getMatchesByDate(date: Date) {
        tryToExecute({
            getFavoriteLeagueMatchesByDate(date, "Africa/Cairo")
        }, ::onSuccessFavourites, ::onError)
    }

    private fun onSuccessFavourites(f: Flow<List<Pair<League, List<Fixture>>>>) {
        collectFlow(f) { pair ->
            copy(
                favoriteItems = pair.toUiState(
                    onCompetitionClick = ::onCompetitionClick,
                    onMatchClick = ::onMatchClicked
                ),
                isLoading = false,
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false)
        }
    }

    private fun onMatchClicked(homeTeamId: Int, awayTeamId: Int, date: String) {
        _event.update { Event(HomeEvents.NavigateToMatch(homeTeamId, awayTeamId, date)) }
    }

    private fun onCompetitionClick(leagueId: Int, season: Int) {
        _event.update { Event(HomeEvents.NavigateToCompetition(leagueId, season)) }
    }
}