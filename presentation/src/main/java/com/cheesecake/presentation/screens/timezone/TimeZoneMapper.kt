package com.cheesecake.presentation.screens.timezone

@JvmName("timezonesToTimezoneItemsUiState")
fun List<String>.toUiState(selectedTimezone: String, onTimezoneClicked: (String) -> Unit): List<TimezoneItemUiState> {
    return this.map { timezone ->
        TimezoneItemUiState(timezone = timezone, isSelected = timezone == selectedTimezone, onTimezoneClicked = {
            onTimezoneClicked(timezone)
        })
    }
}