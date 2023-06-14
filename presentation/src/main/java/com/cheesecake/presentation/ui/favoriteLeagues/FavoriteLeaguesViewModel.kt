package com.cheesecake.presentation.ui.favoriteLeagues

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetFavoriteLeaguesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteLeaguesViewModel @Inject constructor(
    private val getFavoriteLeaguesUseCase: GetFavoriteLeaguesUseCase,
    private val favoriteLeagueUseCase: FavouriteLeagueUseCase
) : BaseViewModel<FavoriteLeaguesUIState>(FavoriteLeaguesUIState()) {

    init {
        getFavoriteLeagues()
    }

    private fun getFavoriteLeagues() {
        tryToExecute({ getFavoriteLeaguesUseCase() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<League>>) {
        viewModelScope.launch {
            flow.collect { leagues ->
                _state.update { favoriteLeaguesUIState ->
                    favoriteLeaguesUIState.copy(
                        leagues = leagues.map {
                            FavoriteLeagueUIState(
                                id = it.leagueId,
                                leagueName = it.leagueName,
                                leagueCountry = it.country,
                                imageUrl = it.leagueLogo,
                                onFavorite = { toggleFavourite() },
                                isFavourite = it.isFavourite,
                            )
                        },
                        isLeaguesIsEmpty = leagues.isEmpty(),
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }

    private fun toggleFavourite() {
        viewModelScope.launch {
            favoriteLeagueUseCase(39, 2022).toString()
        }
    }

}