package com.cheesecake.presentation.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetFavoriteLeaguesMatchesByDateUseCase
import com.cheesecake.domain.usecases.GetNextThirtyDaysUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNextThirtyDaysUseCase: GetNextThirtyDaysUseCase,
    private val getFavoriteLeaguesMatchesByDateUseCase: GetFavoriteLeaguesMatchesByDateUseCase,
): BaseViewModel<HomeUIState, HomeNavigationEvent>(HomeUIState(), Event()) {

    init {

        tryToExecute({
            val d = getNextThirtyDaysUseCase().first()

            getFavoriteLeaguesMatchesByDateUseCase(d, "Africa/Cairo")
        }, ::onSuccess, ::onError)

    }

    private fun onSuccess(f: Flow<List<Pair<League, List<Fixture>>>>) {
        viewModelScope.launch {

            f.collect {

                Log.d("TAG", "onSuccess1: ${it}")
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false)
        }
        Log.d("TAG", e.message.toString())
    }
}