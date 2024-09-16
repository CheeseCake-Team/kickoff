package com.cheesecake.presentation.screens.timezone

data class TimezoneItemUiState(
    val timezone: String = "",
    val isSelected: Boolean = false,
    val onTimezoneClicked: () -> Unit = {}
)