package com.cheesecake.presentation.screens.discover

import com.cheesecake.presentation.models.CountryItemUIState
import kotlinx.coroutines.flow.MutableStateFlow


data class DiscoverTeamCountryUiState(
    val isLoading: Boolean = true,
    val searchInput: MutableStateFlow<String> = MutableStateFlow(""),
    val data: List<CountryItemUIState> = emptyList(),
    val isNoResult: Boolean = false,
    val isError: String = "Error"
)