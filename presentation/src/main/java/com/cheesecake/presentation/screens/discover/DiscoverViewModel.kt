package com.cheesecake.presentation.screens.discover

import android.util.Log
import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.domain.usecases.GetSearchTeamCountryUseCase
import com.cheesecake.domain.usecases.GetTeamCountryUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getTeamCountryUseCase: GetTeamCountryUseCase,
    private val getSearchTeamCountryUseCase: GetSearchTeamCountryUseCase,
) :
    BaseViewModel<DiscoverTeamCountryUIState>(DiscoverTeamCountryUIState()) {

    var search = MutableStateFlow<String?>(null)

    init {
        getData()
    }

    private fun applySearch() {
        if (search.value != null) {
            tryToExecute(
                { getSearchTeamCountryUseCase(search = search.value!!) },
                ::onSuccess,
                ::onError
            )
        }
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


    private fun onSuccess(flow: Flow<List<TeamCountry>>) {
        GlobalScope.launch {
            flow.collect { list ->
                list.let {
                    _state.update { discoverTeamCountryUIState ->
                        Log.i("getData search: ", it.toString())
                        discoverTeamCountryUIState.copy(
                            data = it.map { it.toUIModel() },
                            isLoading = false
                        )
                    }
                }
            }
        }

    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }
}