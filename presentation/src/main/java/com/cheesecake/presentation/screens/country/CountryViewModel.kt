package com.cheesecake.presentation.screens.country

import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.discover.CountryNavigationArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    val countryNavigationArgs: CountryNavigationArgs
) : BaseViewModel<CountryUIState, CountryEvents>(
    CountryUIState(),
    Event()
) {

    init {
        getData()
    }

    private fun onBackClick() {
        _event.update { Event(CountryEvents.NavigateBack) }
    }

    override fun getData() {
        _state.update {
            it.copy(
                countryName = countryNavigationArgs.countryName,
                imageUrl = countryNavigationArgs.imageUrl,
                onBackClick = { onBackClick() }
            )
        }
    }
}