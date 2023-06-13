package com.cheesecake.presentation.ui.favoriteLeagues

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetFavoriteLeaguesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteLeaguesViewModel @Inject constructor(
    private val getFavoriteLeaguesUseCase: GetFavoriteLeaguesUseCase
) : BaseViewModel<FavoriteLeagueUIState>(FavoriteLeagueUIState()){

    init {
        getFavoriteLeagues()
    }

    private fun getFavoriteLeagues() {
        tryToExecute({ getFavoriteLeaguesUseCase() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<League>>) {
        viewModelScope.launch {
            flow.collect { leagues ->
                _state.update { it.copy(leagues = leagues, isLeaguesIsEmpty = leagues.isEmpty(),isLoading = false) }
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false) }
    }

}