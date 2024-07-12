package com.cheesecake.presentation.screens.discover

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.usecases.ManageCountriesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val manageCountriesUseCase: ManageCountriesUseCase,
) : BaseViewModel<DiscoverTeamCountryUIState, DiscoverTeamCountryEvents>(
    DiscoverTeamCountryUIState(),
    Event()
) {

    init {
        getData()
    }

    private fun applySearch(searchQuery: String) {
        tryToExecute(
            { manageCountriesUseCase.searchForCountries(searchQuery) },
            ::onSearchSuccess,
            ::onError
        )
    }

    private fun getData() {
        collectFlow(state.value.searchInput) {
            if (it.isBlank() || it.isEmpty()) {
                tryToExecute({ manageCountriesUseCase.getCountries() }, ::onSuccess, ::onError)
            } else {
                applySearch(it)
            }
            state.value
        }
    }

    private fun onSuccess(result: List<Country>) {
        result.let { list ->
            _state.update { discoverTeamCountryUIState ->
                discoverTeamCountryUIState.copy(
                    data = list.map { it.toUIModel { ::onClick.invoke(it.name, it.flag) } },
                    isLoading = false,
                    isNoResult = false
                )
            }
        }
    }

    private fun onClick(countryName: String, imageUrl: String) {
        _event.update { Event(DiscoverTeamCountryEvents.NavigateToCountry(countryName, imageUrl)) }
    }

    private fun onSearchSuccess(flow: Flow<List<Country>>) {
        collectFlow(flow) { list ->
            copy(
                data = list.map { it.toUIModel { ::onClick.invoke(it.name, it.flag) } },
                isLoading = false, isNoResult = list.isEmpty()
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }
}