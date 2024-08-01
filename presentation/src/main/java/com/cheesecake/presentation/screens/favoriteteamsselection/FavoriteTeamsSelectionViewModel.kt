package com.cheesecake.presentation.screens.favoriteteamsselection

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.domain.usecases.OnboardingUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUiState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavoriteTeamsSelectionViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val onboardingUseCase: OnboardingUseCase,
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
) : BaseViewModel<FavoriteTeamsSelectionUiState, FavoriteTeamsSelectionNavigationEvent>(
    FavoriteTeamsSelectionUiState(),
    Event()
) {
    init {
        getData()
    }

    suspend fun setOnboardingShown() {
        onboardingUseCase.saveOnboardingState(isComplete = true)
    }

    private fun onGettingFavoriteCompetitionsSuccess(favouriteCompetitions: Flow<List<League>>) {
        collectFlow(favouriteCompetitions) {
            tryToExecute(
                { manageTeamsUseCase.getCompetitionTeams(it) },
                ::onGettingTeamsSuccess,
            )
            this
        }
    }

    fun onSearchQueryChanged(searchQuery: CharSequence) {
        val displayedTeams = if (searchQuery.isNotBlank())
            state.value.teamsItemsUiState.filter {
                it.teamName.contains(searchQuery, true)
            }
        else
            state.value.teamsItemsUiState
        _state.update {
            it.copy(
                isLoading = false,
                isNoResult = displayedTeams.isEmpty(),
                displayedTeams = displayedTeams,
            )
        }
    }

    private fun onGettingTeamsSuccess(triples: List<Triple<List<Team>, Int, Int>>) {
        triples.flatMap {
            it.first.toUiState { team -> onFavouriteTeamSelect(team, it.second, it.third) }
        }.also { teamsItemsUiState ->
            _state.update {
                it.copy(
                    teamsItemsUiState = teamsItemsUiState,
                    displayedTeams = teamsItemsUiState,
                    isLoading = false,
                    isNoResult = teamsItemsUiState.isEmpty(),
                    onGetStartedClick = ::addTeamsToFavourite
                )
            }
        }
    }

    private fun onFavouriteTeamSelect(team: Team, leagueId: Int, season: Int) {
        manageTeamsUseCase.toggleTeamFavoriteStatus(team, leagueId, season)
        _state.update { favTeamsSelectionUIState ->
            favTeamsSelectionUIState.copy(
                teamsItemsUiState = favTeamsSelectionUIState.teamsItemsUiState.map {
                    if (it.teamId == team.id) it.copy(isSelected = !it.isSelected) else it
                },
                displayedTeams = favTeamsSelectionUIState.teamsItemsUiState.map {
                    if (it.teamId == team.id) it.copy(isSelected = !it.isSelected) else it
                }
            )
        }
    }

    private fun addTeamsToFavourite() {
        tryToExecute({ manageTeamsUseCase.saveSelectedTeams() }, ::onAddSuccess)
    }

    private fun onAddSuccess(boolean: Boolean) {
        _event.update { Event(FavoriteTeamsSelectionNavigationEvent.NavigateToHome) }
    }

    override fun getData() {
        tryToExecute(
            { manageCompetitionsUseCase.getFavoriteCompetition() },
            ::onGettingFavoriteCompetitionsSuccess
        )
    }
}