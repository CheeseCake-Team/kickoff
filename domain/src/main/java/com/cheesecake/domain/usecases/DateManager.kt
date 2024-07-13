package com.cheesecake.domain.usecases

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class DateManager @Inject constructor() {
    fun getDatesInRange(range: IntRange): List<Date> = (range).map {
        Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, it) }.time
    }

    fun getToday(): Date = Date(System.currentTimeMillis())

    /**
     * @author Abdurrahman & Mahmoud
     * */
    fun isSameDay(otherDate: Date, date: Date): Boolean {
        val localDate1 = date.toLocalDate()
        val localDate2 = otherDate.toLocalDate()
        return localDate1.isEqual(localDate2)
    }

    /**
     * @author Mahmoud
     * */
    private fun Date.toLocalDate(): LocalDate =
        toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

    /**
     * @author Mahmoud
     * */
    fun toStanderDateString(date: Date): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(date)
    }
}