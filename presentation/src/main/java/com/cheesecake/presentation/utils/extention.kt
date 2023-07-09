package com.cheesecake.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date

fun Date.toStanderDateString(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(this)
}
fun Date.toStanderTimeString(): String {
    val dateFormat = SimpleDateFormat("HH:mm")
    return dateFormat.format(this)
}