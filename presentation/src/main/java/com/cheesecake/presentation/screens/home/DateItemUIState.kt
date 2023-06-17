package com.cheesecake.presentation.screens.home

import java.util.Date
import java.text.SimpleDateFormat
import java.util.*

data class DateItemUIState(
    val month: String = "",
    val day: String = "",
    val date: Date = Date(),
    val isSelected: Boolean = false,
    val onClickDate: (date: Date) -> Unit
)

fun Date.toDateUiState(onClickDate: (date: Date) -> Unit): DateItemUIState {
    val dateFormat = SimpleDateFormat("MMM", Locale.ENGLISH)
    val month = dateFormat.format(this)

    val dayFormat = SimpleDateFormat("dd", Locale.ENGLISH)
    val day = dayFormat.format(this)

    return DateItemUIState(
        month = month,
        day = day,
        isSelected = false,
        onClickDate = onClickDate,
        date = this
    )
}
