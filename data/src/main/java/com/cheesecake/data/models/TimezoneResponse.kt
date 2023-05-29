package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class TimezoneResponse(
    @SerializedName("response")
    val timezones: List<String>
)