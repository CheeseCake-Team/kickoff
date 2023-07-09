package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TimezoneDTO(
    @SerializedName("response")
    val timezones: List<String>
)