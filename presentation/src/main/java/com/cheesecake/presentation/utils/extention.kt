package com.cheesecake.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date

fun Date.toFormattedString(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(this)
}