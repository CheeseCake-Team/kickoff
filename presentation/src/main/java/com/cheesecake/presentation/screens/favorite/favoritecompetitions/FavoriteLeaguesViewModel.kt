package com.cheesecake.presentation.screens.favorite.favoritecompetitions

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toLeaguesUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteLeaguesViewModel @Inject constructor(
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
) : BaseViewModel<FavoriteLeaguesUIState, FavoriteCompetitionsNavigationEvent>(
    FavoriteLeaguesUIState(), Event()
) {
    init {
        getData()
    }

    private fun onSuccess(flow: Flow<List<Competition>>) {
        collectFlow(flow) { leagues ->
            copy(
                competitions = leagues.map { league ->
                    league.toLeaguesUIState({
                        removeFavoriteCompetition(league.competitionId)
                    }, { navigateToLeague(league.competitionId) })
                }, isLeaguesIsEmpty = leagues.isEmpty(), isLoading = false
            )
        }
    }

    override fun getData() {
        tryToExecute({ manageCompetitionsUseCase.getFavoriteCompetition() }, ::onSuccess)
    }

    private fun navigateToLeague(leagueId: Int) {
        _event.update { Event(FavoriteCompetitionsNavigationEvent.NavigateToCompetition(leagueId)) }
    }

    private fun removeFavoriteCompetition(competitionId: Int) {
        viewModelScope.launch { manageCompetitionsUseCase.removeFavoriteCompetition(competitionId) }
    }
}
