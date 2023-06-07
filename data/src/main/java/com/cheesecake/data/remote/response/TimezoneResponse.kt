package com.cheesecake.data.remote.response

import com.google.gson.annotations.SerializedName

data class TimezoneResponse(
    @SerializedName("response")
    val timezones: List<String>
)