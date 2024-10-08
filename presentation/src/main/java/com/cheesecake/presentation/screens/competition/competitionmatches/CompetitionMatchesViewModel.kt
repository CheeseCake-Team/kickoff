package com.cheesecake.presentation.screens.competition.competitionmatches

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.ManageMatchesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.competition.CompetitionArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CompetitionMatchesViewModel @Inject constructor(
    private val manageMatchesUseCase: ManageMatchesUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CompetitionMatchesUiState, CompetitionMatchesEvent>(
    CompetitionMatchesUiState(),
    Event()
) {
    private val competitionArgs = CompetitionArgs(savedStateHandle)

    init {
        getData()
    }

    private fun onSuccess(result: List<Pair<String, List<Fixture>>>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        _state.update { it.copy(data = result.toUiState(::onMatchClicked)) }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            {
                manageMatchesUseCase.fetchAndGroupMatchesByDate(
                    "Africa/Cairo",
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            },
            ::onSuccess,
        )
    }

    private fun onMatchClicked(homeTeamId: Int, awayTeamId: Int, date: String) {
        _event.update {
            Event(
                CompetitionMatchesEvent.MatchClickedEvent(
                    homeTeamId,
                    awayTeamId,
                    date
                )
            )
        }
    }
}