package com.cheesecake.ui.fragment.leagueMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase: GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase
) : BaseViewModel<LeagueMatchesUIState>() {

    override val uiState = LeagueMatchesUIState()

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            {getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase("Africa/Cairo", 39, 2022)},
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<Pair<String, List<Fixture>>>) {
        _state.update { it.copy(data = result, isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }

}