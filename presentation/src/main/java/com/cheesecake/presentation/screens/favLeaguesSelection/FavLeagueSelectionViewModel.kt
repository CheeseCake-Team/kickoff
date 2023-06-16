package com.cheesecake.presentation.screens.favLeaguesSelection

import com.cheesecake.domain.usecases.GetLeagueListUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavLeagueSelectionViewModel @Inject constructor(
    private val GetLeagueListUseCase: GetLeagueListUseCase
    ) : BaseViewModel<FavLeagueSelectionUIState>(FavLeagueSelectionUIState()) {

    private val _favLeagueSelectionUIState = MutableStateFlow(FavLeagueSelectionUIState())
    val favLeagueSelectionUIState = _favLeagueSelectionUIState.asStateFlow()

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
                        allLeagues = leagues,
                        isLoading = false
                    )
                }
            },
            { error ->
                _favLeagueSelectionUIState.update { it.copy( errorMessage = error.message.toString(), isLoading = false) }

            }
        )
    }
}