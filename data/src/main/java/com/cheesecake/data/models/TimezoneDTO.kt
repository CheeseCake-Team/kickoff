package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class TimezoneDTO(
    @SerializedName("response")
    val timezones: List<String>
)