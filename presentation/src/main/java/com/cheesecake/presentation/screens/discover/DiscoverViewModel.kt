package com.cheesecake.presentation.screens.discover

import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.domain.usecases.GetSearchTeamCountryUseCase
import com.cheesecake.domain.usecases.GetTeamCountryUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getTeamCountryUseCase: GetTeamCountryUseCase,
    private val getSearchTeamCountryUseCase: GetSearchTeamCountryUseCase,
) : BaseViewModel<DiscoverTeamCountryUIState, DiscoverTeamCountryEvents>(
    DiscoverTeamCountryUIState(),
    Event()
) {

    init {
        getData()
    }

    private fun applySearch(searchQuery: String) {
        tryToExecute({ getSearchTeamCountryUseCase(searchQuery) }, ::onSearchSuccess, ::onError)
    }

    private fun getData() {
        collectFlow(state.value.searchInput) {
            if (it.isBlank() || it.isEmpty()) {
                tryToExecute({ getTeamCountryUseCase() }, ::onSuccess, ::onError)
            } else {
                applySearch(it)
            }
            state.value
        }
    }

    private fun onSuccess(result: List<TeamCountry>) {
        result.let { list ->
            _state.update { discoverTeamCountryUIState ->
                discoverTeamCountryUIState.copy(
                    data = list.map { it.toUIModel(::onClick) },
                    isLoading = false
                )
            }
        }
    }

    private fun onClick(countryName: String) {
        _event.update { Event(DiscoverTeamCountryEvents.NavigateToCountry(countryName)) }
    }


    private fun onSearchSuccess(flow: Flow<List<TeamCountry>>) {
        collectFlow(flow) { list ->
            copy(data = list.map { it.toUIModel(::onClick) }, isLoading = false)
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }

}