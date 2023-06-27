package com.cheesecake.presentation.screens.favTeamsSelection

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.AddFavouriteTeamListUseCase
import com.cheesecake.domain.usecases.GetFavoriteLeaguesUseCase
import com.cheesecake.domain.usecases.GetTeamBySearchUseCase
import com.cheesecake.domain.usecases.GetTeamListUseCase
import com.cheesecake.domain.usecases.OnboardingUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toFavTeamItemUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavTeamsSelectionViewModel @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase,
    private val onboardingUseCase: OnboardingUseCase,
    private val getAllFavouriteLeagues : GetFavoriteLeaguesUseCase,
    private val addFavouriteTeamListUseCase: AddFavouriteTeamListUseCase,
    private val getTeamBySearchUseCase: GetTeamBySearchUseCase
) : BaseViewModel<FavTeamsSelectionUIState, FavTeamsSelectionNavigationEvent>(
    FavTeamsSelectionUIState(),
    Event()
) {

    init {
        collectFlow(state.value.searchInput.debounce(1000).distinctUntilChanged()) {
            if (it.isBlank() || it.isEmpty()) {
                tryToExecute({ getAllFavouriteLeagues() }, ::onLeaguesSuccess, ::onLeaguesError)
            } else {
                tryToExecute({ getTeamBySearchUseCase(it) }, ::onSearchSuccess, ::onSearchError)
            }
            state.value
        }
    }


    suspend fun setOnboardingShown() {
        onboardingUseCase.setOnboardingShown()
    }


    private fun onLeaguesSuccess(leagues: Flow<List<League>>) {
        collectFlow(leagues){ favouriteLeagues->
            tryToExecute({
                getTeamListUseCase(favouriteLeagues)
            }, ::onTeamsSuccess, ::onTeamsError)
           this
        }
    }

    private fun onLeaguesError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.message.toString(), isLoading = false)
        }
    }

    private fun onTeamsSuccess(teams: List<Team>) {
        _state.update {
            it.copy(
                teamsItems = teams.map { team ->
                    team.toFavTeamItemUIState { onFavouriteTeamSelect(team) }
                },
                isLoading = false,
                onGetStartedClick = { addToFavourite() }
            )
        }
    }

    private fun onTeamsError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.message.toString(), isLoading = false)
        }
    }

    private fun onFavouriteTeamSelect(team: Team) {
        addFavouriteTeamListUseCase.addTeam(team)
        _state.update { favTeamsSelectionUIState ->
            favTeamsSelectionUIState.copy (
                teamsItems = favTeamsSelectionUIState.teamsItems.map {
                    if (it.teamId == team.id) it.copy (isSelected = !it.isSelected) else it
                }
            )
        }
    }

    private fun addToFavourite() {
        tryToExecute({ addFavouriteTeamListUseCase.execute() }, ::onAddSuccess, ::onError)
    }

    private fun onAddSuccess(boolean: Boolean) {
        _event.update { Event(FavTeamsSelectionNavigationEvent.NavigateToHome) }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false) }
    }

    private fun onSearchSuccess(items: List<Team>) {
        _state.update {
            it.copy(
                teamsItems = items.map { team ->
                    team.toFavTeamItemUIState { onFavouriteTeamSelect(team) }
                },
                isLoading = false
            )
        }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(errorMessage = throwable.message.toString(), isLoading = false) }
    }



}