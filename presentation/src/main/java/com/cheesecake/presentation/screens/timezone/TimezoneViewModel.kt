package com.cheesecake.presentation.screens.timezone

import com.cheesecake.domain.usecases.ManageTimezoneUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TimezoneViewModel @Inject constructor(
    private val manageTimezoneUseCase: ManageTimezoneUseCase
) : BaseViewModel<TimezoneUiState, TimezoneEvents>(TimezoneUiState(), Event()) {
    init {
        getData()
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        collectFlow(manageTimezoneUseCase.getTimezone()) { timezone ->
            copy(selectedTimezone = timezone)
        }
        tryToExecute({ manageTimezoneUseCase.getTimezones() }, ::onGettingTimezonesSuccess)
    }

    private fun onGettingTimezonesSuccess(timezones: List<String>) {
        _state.update {
            it.copy(
                timezoneItemUiState = timezones.toUiState(
                    it.selectedTimezone,
                    ::onTimezoneClicked
                )
            )
        }
        _isLoading.update { false }
        _errorUiState.update { null }
    }

    private fun onTimezoneClicked(timezone: String) {
        tryToExecute({ manageTimezoneUseCase.setTimezone(timezone) }, ::onSettingTimezoneSuccess)
    }

    private fun onSettingTimezoneSuccess(timezone: String) {
        _state.update {
            it.copy(
                selectedTimezone = timezone,
                timezoneItemUiState = it.timezoneItemUiState.map { item ->
                    item.copy(isSelected = item.timezone == timezone)
                }
            )
        }
    }

    fun onBackClicked() {
        _event.update { Event(TimezoneEvents.OnBackClicked) }
    }
}