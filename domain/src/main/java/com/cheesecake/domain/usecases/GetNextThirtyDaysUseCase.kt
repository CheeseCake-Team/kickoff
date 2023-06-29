package com.cheesecake.domain.usecases

import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class GetNextThirtyDaysUseCase @Inject constructor() {

    operator fun invoke(): List<Date> = (-12 until 30).map {
        Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, it) }.time
    }

}