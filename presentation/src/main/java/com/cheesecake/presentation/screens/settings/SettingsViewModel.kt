package com.cheesecake.presentation.screens.settings

import com.cheesecake.domain.usecases.ManageSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val manageSeasonUseCase: ManageSeasonUseCase
) : BaseViewModel<SettingsUiState, SettingsEvent>(SettingsUiState(), Event()) {
    init {
        getData()
    }

    override fun getData() {
        collectFlow(manageSeasonUseCase.getSeason()) { season ->
            copy(selectedSeason = season)
        }
    }

    fun onSeasonClicked() {
        _event.update { Event(SettingsEvent.OnSeasonClicked) }
    }
}