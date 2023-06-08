package com.cheesecake.ui.fragment.league

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase
) : BaseViewModel() {

    private val _leagueUIState = MutableStateFlow(LeagueUIState())
    val leagueUIState = _leagueUIState.asStateFlow()

    init {
        getLeague()
    }

    fun toggleFavourite() {
        viewModelScope.launch {
            favouriteLeagueUseCase(39, 2022)?.let {
                _leagueUIState.update { uiState ->
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
                _leagueUIState.update { uiState ->
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