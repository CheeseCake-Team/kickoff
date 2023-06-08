package com.cheesecake.ui.fragment.league

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase
) : BaseViewModel<LeagueUIState>() {

    override val uiState = LeagueUIState()

    init {
        getLeague()
    }

    fun toggleFavourite() {
        viewModelScope.launch {
            favouriteLeagueUseCase(39, 2022)?.let {
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
            getLeagueByIdAndSeasonUseCase(39, 2022)?.let { league ->
                _state.update { uiState ->
                    uiState.copy(
                        leagueName = league.leagueName,
                        seasonStartEndYear = "${league.seasonStartYear}/${league.seasonEndYear}",
                        imageUrl = league.leagueLogo,
                        isFavourite = league.isFavourite,
                        isLoading = false
                    )
                }
            }
        }
    }


}