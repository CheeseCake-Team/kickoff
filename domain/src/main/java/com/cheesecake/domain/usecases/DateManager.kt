package com.cheesecake.domain.usecases

import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class DateManager @Inject constructor() {
    fun getDatesInRange(range: IntRange): List<Date> = (range).map {
        Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, it) }.time
    }

    fun getToday(): Date = Date(System.currentTimeMillis())
}