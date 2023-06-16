package com.cheesecake.domain.usecases

import java.util.Calendar
import javax.inject.Inject

class GetNextThirtyDaysUseCase @Inject constructor() {

    operator fun invoke(): List<Int> = (0 until 31).map {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, it)
        calendar.get(Calendar.DAY_OF_MONTH)
    }

}