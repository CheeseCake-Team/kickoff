package com.cheesecake.presentation.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetFavoriteLeaguesMatchesByDateUseCase
import com.cheesecake.domain.usecases.GetNextThirtyDaysUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNextThirtyDaysUseCase: GetNextThirtyDaysUseCase,
    private val getFavoriteLeaguesMatchesByDateUseCase: GetFavoriteLeaguesMatchesByDateUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase

) : BaseViewModel<HomeUIState, HomeEvents>(HomeUIState(), Event()) {

    init {
        viewModelScope.launch {
            favouriteLeagueUseCase(39, 2023)
            favouriteLeagueUseCase(39, 2022)
            favouriteLeagueUseCase(75, 2023)
        }
        getDateMatches(getNextThirtyDaysUseCase().first())
        tryToExecute({ getNextThirtyDaysUseCase() }, ::onSuccessDate, ::onError)
    }

    private fun onSuccessDate(dates: List<Date>) {
        _state.update {
            it.copy(dateItems = dates.map { date ->
                date.toDateUiState { onClickDate(date) }
            })
        }
        Log.i("onSuccessDate: ", _state.value.dateItems.toString())
    }

    private fun onClickDate(date: Date) {
        getDateMatches(date)
    }

    private fun getDateMatches(date: Date) {
        tryToExecute({
            getFavoriteLeaguesMatchesByDateUseCase(date, "Africa/Cairo")
        }, ::onSuccessFavourites, ::onError)
    }


    private fun onSuccessFavourites(f: Flow<List<Pair<League, List<Fixture>>>>) {
        collectFlow(f) { pair ->
            copy(
                isLoading = false,
                favoriteItems = pair.toHomeFavouriteUiState(
                    onLeagueClick = ::onLeagueClicked,
                    onMatchClick = ::onMatchClicked
                )
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false)
        }
        Log.d("TAG", e.message.toString())
    }

    private fun onMatchClicked() {
        _event.update { Event(HomeEvents.MatchClickedEvent) }
    }

    private fun onLeagueClicked(leagueId: Int, season: Int) {
        _event.update { Event(HomeEvents.LeagueClickEvent(leagueId,season)) }
    }
}