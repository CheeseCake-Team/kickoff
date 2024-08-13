package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.DateManager
import com.cheesecake.domain.usecases.ManageMatchesUseCase
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
    private val manageMatchesUseCase: ManageMatchesUseCase,
) : BaseViewModel<HomeUiState, HomeEvents>(
    HomeUiState(selectedDate = dateManager.getToday()),
    Event()
) {
    init {
        getDates()
        getData()
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
                dateItems = dateItems,
                currentDatePosition = dateItems.indexOfFirst { dateItemUIState -> dateItemUIState.isSelected },
                selectedDate = date,
                favoriteItems = emptyList()
            )
        }
        _isLoading.update { true }
        _errorUiState.update { null }
        getMatchesByDate(state.value.selectedDate)
    }

    private fun getMatchesByDate(date: Date) {
        tryToExecute({
            manageMatchesUseCase.getFavoriteCompetitionsMatches(date, "Africa/Cairo")
        }, ::onSuccessFavourites)
    }

    private fun onSuccessFavourites(f: Flow<List<Pair<League, List<Fixture>>>>) {
        collectFlow(f) { pair ->
            copy(
                favoriteItems = pair.toUiState(
                    onCompetitionClick = ::onCompetitionClick,
                    onMatchClick = ::onMatchClicked
                )
            )
        }
        _isLoading.update { false }
        _errorUiState.update { null }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        getMatchesByDate(state.value.selectedDate)
    }

    private fun onMatchClicked(homeTeamId: Int, awayTeamId: Int, date: String) {
        _event.update { Event(HomeEvents.NavigateToMatch(homeTeamId, awayTeamId, date)) }
    }

    private fun onCompetitionClick(leagueId: Int, season: Int) {
        _event.update { Event(HomeEvents.NavigateToCompetition(leagueId, season)) }
    }
}