package com.cheesecake.presentation.ui.league

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase
) : BaseViewModel<LeagueUIState>(LeagueUIState()) {

    init {
        getLeague()
    }

    fun toggleFavourite() {
        viewModelScope.launch {
            favouriteLeagueUseCase(39, 2022).let {
                _state.update { uiState ->
                    uiState.copy(
                        isFavourite = it.isFavourite
                    )
                }
            }
        }
    }

    private fun getLeague() {
        viewModelScope.launch {
            getLeagueByIdAndSeasonUseCase(39, 2022).let { league ->
                _state.update { uiState ->
                    uiState.copy(
                        leagueName = league.name,
                        seasonStartEndYear = "${league.seasonStartYear}/${league.seasonEndYear}",
                        imageUrl = league.imageUrl,
                        isFavourite = league.isFavourite,
                        isLoading = false
                    )
                }
            }
        }
    }
}