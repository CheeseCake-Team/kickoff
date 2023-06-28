package com.cheesecake.presentation.screens.home

import java.util.Date
import java.text.SimpleDateFormat
import java.util.*

data class DateItemUIState(
    val month: String = "",
    val day: String = "",
    val date: Date = Date(),
    var isSelected: Boolean = false,
    val onClickDate: (date: Date) -> Unit
)

fun Date.toDateUiState(onClickDate: (date: Date) -> Unit): DateItemUIState {
    val dateFormat = SimpleDateFormat("MMM", Locale.ENGLISH)
    val month = dateFormat.format(this)

    val dayFormat = SimpleDateFormat("dd", Locale.ENGLISH)
    val day = dayFormat.format(this)

    val currentDayFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val currentDay = currentDayFormat.format(Date())
    val thisDay = currentDayFormat.format(this)

    val isSelected = currentDay == thisDay

    return DateItemUIState(
        month = month,
        day = day,
        isSelected = isSelected,
        onClickDate = onClickDate,
        date = this
    )
}