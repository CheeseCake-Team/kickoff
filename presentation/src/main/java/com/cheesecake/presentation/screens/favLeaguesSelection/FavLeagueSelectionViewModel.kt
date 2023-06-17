package com.cheesecake.presentation.screens.favLeaguesSelection

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.KickoffException
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.AddFavouriteLeagueListUseCase
import com.cheesecake.domain.usecases.GetLeagueListUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toFavLeagueItemUIState
import com.cheesecake.presentation.mapper.toLeague
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.league.LeagueNavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavLeagueSelectionViewModel @Inject constructor(
    private val GetLeagueListUseCase: GetLeagueListUseCase,
    private val AddFavouriteLeagueListUseCase: AddFavouriteLeagueListUseCase
) : BaseViewModel<FavLeagueSelectionUIState, FavLeagueSelectionNavigationEvent>(
    FavLeagueSelectionUIState(),
    Event()
) {

    private val _favLeagueSelectionUIState = MutableStateFlow(FavLeagueSelectionUIState())
    val favLeagueSelectionUIState = _favLeagueSelectionUIState.asStateFlow()

    private val _selectedLeagues = MutableStateFlow<List<League>>(emptyList())
    val selectedLeagues: StateFlow<List<League>> = _selectedLeagues

    init {
        getAllLeagues()
    }

    private fun getAllLeagues() {
        tryToExecute(
            {
                GetLeagueListUseCase()
            },
            { leagues ->
                _favLeagueSelectionUIState.update {
                    it.copy(
                        allLeagues = leagues.map {
                            it.toFavLeagueItemUIState {
                                onFavouriteLeagueSelect(
                                    it
                                )
                            }
                        },
                        isLoading = false
                    )

                }
            },
            { error ->
                _favLeagueSelectionUIState.update {
                    it.copy(
                        errorMessage = error.message.toString(),
                        isLoading = false
                    )
                }
            }
        )
    }

    fun onFavouriteLeagueSelect(favleagueItem: FavLeagueItemUIState) {

        val league = favleagueItem.toLeague()
        val currentSelectedLeagues = _selectedLeagues.value.toMutableList()
        if (currentSelectedLeagues.contains(league)) {
            currentSelectedLeagues.remove(league)
        } else {
            currentSelectedLeagues.add(league)
        }
        _selectedLeagues.value = currentSelectedLeagues
//        favleagueItem.copy { it.isSelected = true }
    }

    private fun addToFavourite() {
        val selectedItems = selectedLeagues.value
        tryToExecute(
            { AddFavouriteLeagueListUseCase(selectedItems) }, ::onAddSuccess, ::onError
        )
    }

    private fun onAddSuccess(boolean: Boolean) {
        _event.update { Event(FavLeagueSelectionNavigationEvent.NavigateToFavTeamsSelection) }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false)
        }
    }
}