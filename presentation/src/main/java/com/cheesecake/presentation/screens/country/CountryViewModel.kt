package com.cheesecake.presentation.screens.country

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.domain.usecases.GetSearchTeamCountryUseCase
import com.cheesecake.domain.usecases.GetTeamCountryUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.models.TeamCountryUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
) :
    BaseViewModel<CountryUIState, CountryEvents>(
        CountryUIState(),
        Event()
    ) {





}