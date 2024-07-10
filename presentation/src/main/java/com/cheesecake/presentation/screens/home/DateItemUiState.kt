package com.cheesecake.presentation.screens.home

import java.util.Date

data class DateItemUiState(
    val month: String = "",
    val day: String = "",
    val date: Date = Date(),
    val isSelected: Boolean = false,
    val onClickDate: (date: Date) -> Unit
)