package com.cheesecake.presentation.screens.discover

import android.util.Log
import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.domain.usecases.GetTeamCountryUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(private val getTeamCountryUseCase: GetTeamCountryUseCase) :
    BaseViewModel<DiscoverTeamCountryUIState>(DiscoverTeamCountryUIState()) {


    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getTeamCountryUseCase() },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<TeamCountry>) {
        result.let { list ->
            _state.update { discoverTeamCountryUIState ->
                Log.i("getData: ", list.toString())
                discoverTeamCountryUIState.copy(data = list.map { it.toUIModel() }, isLoading = false)
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }
}