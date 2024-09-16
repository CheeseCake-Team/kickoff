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
) : BaseViewModel<DiscoverTeamCountryUiState, DiscoverTeamCountryEvents>(
    DiscoverTeamCountryUiState(),
    Event()
) {
    init {
        getData()
    }

    private fun applySearch(searchQuery: String) {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            { manageCountriesUseCase.searchForCountries(searchQuery) },
            ::onSearchSuccess,
        )
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        collectFlow(state.value.searchInput) {
            if (it.isBlank()) {
                tryToExecute({ manageCountriesUseCase.getCountries() }, ::onSuccess)
            } else {
                applySearch(it)
            }
            state.value
        }
    }

    private fun onSuccess(result: List<Country>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        result.let { list ->
            _state.update { discoverTeamCountryUIState ->
                discoverTeamCountryUIState.copy(
                    data = list.map { it.toUIModel { ::onClick.invoke(it.name, it.flag) } },
                    isNoResult = false
                )
            }
        }
    }

    private fun onClick(countryName: String, imageUrl: String) {
        _event.update { Event(DiscoverTeamCountryEvents.NavigateToCountry(countryName, imageUrl)) }
    }

    private fun onSearchSuccess(flow: Flow<List<Country>>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        collectFlow(flow) { list ->
            copy(
                data = list.map { it.toUIModel { ::onClick.invoke(it.name, it.flag) } },
                isNoResult = list.isEmpty()
            )
        }
    }
}