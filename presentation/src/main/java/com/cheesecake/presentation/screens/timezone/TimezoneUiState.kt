package com.cheesecake.presentation.screens.timezone

data class TimezoneUiState(
    val selectedTimezone: String = "",
    val timezoneItemUiState: List<TimezoneItemUiState> = emptyList()
)
