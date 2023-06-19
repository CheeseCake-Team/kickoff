package com.cheesecake.presentation.screens.discover

import com.cheesecake.presentation.models.TeamCountryUIState
import kotlinx.coroutines.flow.MutableStateFlow


data class DiscoverTeamCountryUIState(
    val isLoading: Boolean = true,
    val searchInput: MutableStateFlow<String> = MutableStateFlow(""),
    val data: List<TeamCountryUIState> = emptyList(),
    val isError: String = "Error"
)